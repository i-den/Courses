<?php


namespace Service;



use Data\PageDTO;
use Data\UserDTO;
use Repository\UserRepositoryInterface;

class UserService implements UserServiceInterface
{
    const USERS_PER_PAGE = 3;

    /**
     * @var UserRepositoryInterface
     */
    private $userRepository;

    public function __construct(UserRepositoryInterface $userRepository)
    {
        $this->userRepository = $userRepository;
    }

    /**
     * Inserts the UserDTO object in the database
     * and also hashes it's password if
     *
     * - form passwords match
     * - username isn't taken
     *
     * @param UserDTO $user
     * @param string $confirmPassword
     * @throws \Exception
     */
    public function register(UserDTO $user, string $confirmPassword)
    {
        // Filled Password and Confirmed Password doesn't match
        if ($user->getPassword() !== $confirmPassword) {
            throw new \Exception('Password mismatch!');
        }

        // Username is already present in the Database
        if (null !== $this->userRepository->findOneByUsername($user->getUsername())) {
            throw new \Exception('Username already taken, please choose another one!');
        }

        // Hash the user's password using BCrypt and Inserts it in the Database
        $user->setPassword(password_hash($user->getPassword(), PASSWORD_BCRYPT));
        $this->userRepository->insert($user);
    }

    public function isLogged(): bool
    {
        return isset($_SESSION['id']);
    }

    /**
     * Returns the UserDTO object from the database matching
     * the username if
     *
     * - username exists
     * && password matches
     *
     * @param string $username
     * @param string $password
     * @return UserDTO
     * @throws \Exception
     */
    public function login(string $username, string $password): UserDTO
    {
        // Find the User by it's username from the Database
        $userToValidate = $this->userRepository->findOneByUsername($username);

        // No user with the username found
        if (null === $userToValidate) {
            throw new \Exception('Username doesn\'t exist');
        }

        // Returns the user if the Password matches
        $hashedPassword = $userToValidate->getPassword();
        if (password_verify($password, $hashedPassword)) {
            return $userToValidate;
        }

        // Or throws an error it doesn't
        throw new \Exception('Wrong password');
    }

    /**
     * Fetches all users from the database
     *
     * @param int $page
     * @param int $usersPerPage
     * @return UserDTO[]|\Generator
     */
    public function viewAll(int $page): \Generator
    {
        $startingUser = ($page - 1) * self::USERS_PER_PAGE;
        return $this->userRepository->findAll($startingUser, self::USERS_PER_PAGE);
    }

    public function buildUserPageDTO(int $currentPage): PageDTO
    {
        $totalUsers = $this->userRepository->getAmountOfUsers();
        $maximumPages = ceil($totalUsers / self::USERS_PER_PAGE);

        return new PageDTO($currentPage, $maximumPages);
    }

    /**
     * Edits the current logged user's profile if
     *
     * - the new username isn't already taken
     *
     * @param UserDTO $user
     * @throws \Exception
     */
    public function editProfile(UserDTO $user)
    {
        // If another user with the same username exists - throw an error
        if (null !== $this->userRepository->findOneByUsername($user->getUsername())) {
            throw new \Exception('Username is already in use, please choose another');
        }

        $user->setPassword(password_hash($user->getPassword(), PASSWORD_BCRYPT));
        // Else update the current logged user's profile
        $this->userRepository->update($user, $_SESSION['id']);
    }

    /**
     * Returns the current user from the Database
     * if he's logged
     *
     * @return UserDTO|null
     * @throws \Exception
     */
    public function getCurrentUser(): ?UserDTO
    {
        $userToReturn = $this->userRepository->findOneById($_SESSION['id']);

        if ($userToReturn === null) {
            throw new \Exception('Wrong user information, please log in again');
        }

        return $userToReturn;
    }
}
