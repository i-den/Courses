<?php


namespace Http;


use Data\ErrorDTO;
use Data\UserDTO;
use Service\UserServiceInterface;

class UserHttpHandler extends HttpHandler
{

    /**
     * Handles requests made to the index file
     *
     * -redirects to the profile page if logged
     * -asks to register or sign in otherwise
     *
     * @param UserServiceInterface $userService
     */
    public function index(UserServiceInterface $userService)
    {
        if (null === $userService->getCurrentUser()) {
            $this->render('home/index');
        } else {
            $this->render('home/profile');
        }
    }

    /**
     * Handles requests made for registering users
     *
     * @param UserServiceInterface $userService
     * @param array $formData
     */
    public function register(UserServiceInterface $userService,
                             array $formData = [])
    {
        if (isset($formData['register'])) {
            $this->handleRegisterProcess($userService, $formData);
        } else {
            $this->render('user/register');
        }
    }

    /**
     * Handles requests made for logging in
     *
     * @param UserServiceInterface $userService
     * @param array $formData
     */
    public function login(UserServiceInterface $userService,
                          array $formData = [])
    {
        if (isset($formData['login'])) {
            $this->handleLoginProcess($userService, $formData);
        } else {
            $this->render('user/login');
        }
    }

    /**
     * Handles the View Profile page
     *
     * @param UserServiceInterface $userService
     * @param array $formData
     */
    public function profile(UserServiceInterface $userService,
                            array $formData = [])
    {
        if (null === $currentUser = $userService->getCurrentUser()) {
            $this->redirect('login.php');
        }

        if (isset($formData['update'])) {
            $this->handleEditProfileProcess($userService, $formData);
        } else {
            $this->render('user/profile', $currentUser);
        }
    }

    public function all(UserServiceInterface $userService)
    {
        $this->render('user/all', $userService->viewAll());
    }

    private function handleRegisterProcess(UserServiceInterface $userService,
                                           array $formData = [])
    {
        $user = $this->dataBinder->bind(
            array_map('htmlspecialchars',$formData),
            UserDTO::class
        );

        $registerResult = $userService->register($user, $formData['confirmPassword']);

        if (true === $registerResult) {
            $this->redirect('login.php');
        } else {
            $this->render(
                'app/error',
                new ErrorDTO('Cannot register, either username is taken or passwords do not match!')
            );
        }
    }

    private function handleLoginProcess(UserServiceInterface $userService,
                                        array $formData = [])
    {
        $loggedUser = $userService->login($formData['username'], $formData['password']);

        if (null !== $loggedUser) {
            $_SESSION['id'] = $loggedUser->getId();
            $this->redirect('profile.php');
        } else {
            $this->render(
                'app/error',
                new ErrorDTO('Username does not exist or password mismatch')
            );
        }
    }

    private function handleEditProfileProcess(UserServiceInterface $userService,
                                              array $formData = [])
    {
        $user = $this->dataBinder->bind(
            array_map('htmlspecialchars',$formData),
            UserDTO::class
        );

        if ($userService->editProfile($user)) {
            $this->redirect('profile.php');
        } else {
            $this->render(
                'app/error',
                new ErrorDTO('Error editing the profile')
            );
        }
    }


}