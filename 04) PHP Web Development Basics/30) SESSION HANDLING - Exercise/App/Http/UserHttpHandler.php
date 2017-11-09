<?php


namespace Http;


use Data\ErrorDTO;
use Data\PageDTO;
use Data\UserDTO;
use Service\UserServiceInterface;

class UserHttpHandler extends HttpHandler
{

    /**
     * Responsible for handling requests made to the index
     * - if the user is logged redirects to profile
     * - if not renders the home page with register / login links
     *
     * @param UserServiceInterface $userService
     */
    public function index(UserServiceInterface $userService)
    {
        if ($userService->isLogged()) {
            // If the user is logged redirect to his profile page
            $this->redirect('profile.php');
        } else {
            // Else render the home page
            $this->render('home/index');
        }
    }

    /**
     * Responsible for handling requests made to the register page
     *
     * If the form is submitted - try to register the user
     * Otherwise render the registry form
     *
     * @param UserServiceInterface $userService
     * @param array $formData
     */
    public function register(UserServiceInterface $userService,
                             array $formData = [])
    {
        if (isset($formData['register'])) {
            // If the form is submitted handle the register process
            $this->handleRegisterProcess($userService, $formData);
            $this->redirect('login.php');
        } else {
            // If not - render the register form
            $this->render('user/register');
        }
    }

    /**
     *  Responsible for handling requests made to the login page
     *
     * If the form is submitted - try to log the user in
     * Otherwise render the login form
     *
     * @param UserServiceInterface $userService
     * @param array $formData
     */
    public function login(UserServiceInterface $userService,
                          array $formData = [])
    {
        if (isset($formData['login'])) {
            $this->handleLoginProcess($userService, $formData);
            $this->redirect('profile.php');
        } else {
            $this->render('user/login');
        }
    }

    /**
     * Responsible for handling requests made to the profile page
     *
     * Redirects to the login page if user isn't logged in
     * Or tries to update the user's profile if the form is submitted
     * Otherwise just displays the form with the User's information
     *
     * @param UserServiceInterface $userService
     * @param array $formData
     */
    public function profile(UserServiceInterface $userService,
                            array $formData = [])
    {
        // User isn't logged in - redirect to the login page
        if (!isset($_SESSION['id'])) {
            $this->redirect('login.php');
        }

        // Update form is filled - handle the request
        if (isset($formData['update'])) {
            $this->handleEditProfileProcess($userService, $formData);
        } else {
            // Form isn't filled - try to display the user profile
            try {
                // Tries to get the user from the Database by it's ID from the Session
                $this->render('user/profile', $userService->getCurrentUser());
            } catch (\Exception $exception) {
                $this->render(
                // Something went wrong
                    'app/error',
                    new ErrorDTO($exception->getMessage())
                );
            }
        }
    }

    /**
     * Handles all requests made to the view all users page
     * if the current user is logged
     *
     * @param UserServiceInterface $userService
     * @param array $requestData
     */
    public function all(UserServiceInterface $userService,
                        array $requestData = [])
    {
        if (!isset($requestData['page'])) {
            $requestData['page'] = 1;
        }

        if (!filter_var($requestData['page'], FILTER_VALIDATE_INT)) {
            $requestData['page'] = 1;
        }

        $requestData['page'] = intval($requestData['page']);

        $pageDTO = $userService->buildUserPageDTO($requestData['page']);

        if ($requestData['page'] > $pageDTO->getMaximumPages()) {
            $requestData['page'] = 1;
        }

        if ($userService->isLogged()) {
            $this->render(
                'user/all',
                $userService->viewAll($requestData['page']),
                $pageDTO
            );
        } else {
            $this->render(
                'app/error',
                new ErrorDTO('You must be logged to see all users')
            );
        }
    }

    /**
     * Handles the Register form by
     *
     * - validating empty fields
     * - escapes the filled HTML form
     *
     * Then registers the user if
     *
     * - filled passwords match
     * && username isn't taken
     *
     * @param UserServiceInterface $userService
     * @param array $formData
     */
    private function handleRegisterProcess(UserServiceInterface $userService,
                                           array $formData = [])
    {
        // If the form isn't fully filled display an error
        if (empty($formData['username'])
            || empty($formData['password'])
            || empty($formData['confirmPassword'])
            || empty($formData['firstName'])
            || empty($formData['lastName'])
            || empty($formData['bornOn'])
        ) {
            $this->render(
                'app/error',
                new ErrorDTO('Please fill in the form!')
            );
        }

        // Escape HTML characters from the form input
        $formData = array_map('htmlspecialchars', $formData);

        try {
            // Create a new UserDTO from the filled form
            $userToRegister = $this->dataBinder->bind($formData, UserDTO::class);

            // Try to register the UserDTO
            $userService->register($userToRegister, $formData['confirmPassword']);
        } catch (\Exception $exception) {
            // Password mismatch or Username taken
            $this->render(
                'app/error',
                new ErrorDTO($exception->getMessage())
            );
        }
    }

    /**
     * Handles the Login form by
     *
     * - validating empty fields
     *
     * Then tries to log the user in if
     *
     * - username exists
     * && password matches
     *
     * @param UserServiceInterface $userService
     * @param array $formData
     */
    private function handleLoginProcess(UserServiceInterface $userService,
                                        array $formData = [])
    {
        // Login form's username or password isn't filled
        if (empty($formData['username']) || empty($formData['password'])) {
            $this->render(
                'app/error',
                new ErrorDTO('Please fill in the login form')
            );
        }

        try {
            // Tries to get the username from the Database
            $userToLogIn = $userService->login($formData['username'], $formData['password']);
            // Saves his session by storing his ID and logs him in by redirecting to the profile page
            $_SESSION['id'] = $userToLogIn->getId();
        } catch (\Exception $exception) {
            // Username doesn't exist or password is invalid
            $this->render(
                'app/error',
                new ErrorDTO($exception->getMessage())
            );
        }
    }

    /**
     * Handles the Edit Profile process by
     *
     * - validating form input
     *
     * Updates the current user if
     *
     * - new username isn't taken
     *
     * @param UserServiceInterface $userService
     * @param array $formData
     */
    private function handleEditProfileProcess(UserServiceInterface $userService,
                                              array $formData = [])
    {
        if (empty($formData['username'])
            || empty($formData['password'])
            || empty($formData['firstName'])
            || empty($formData['lastName'])
            || empty($formData['bornOn'])
        ) {
            $this->render(
                'app/error',
                new ErrorDTO('Update profile form isn\'t filled')
            );
        }

        try {
            $formData = array_map('htmlspecialchars', $formData);
            $userWithNewDetails = $this->dataBinder->bind($formData, UserDTO::class);
            $userService->editProfile($userWithNewDetails);
            $this->redirect('profile.php');
        } catch (\Exception $exception) {
            $this->render(
                'app/error',
                new ErrorDTO($exception->getMessage())
            );
        }
    }
}