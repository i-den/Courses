<?php


namespace Service;


use Data\UserDTO;
use Repository\UserRepositoryInterface;

class UserService implements UserServiceInterface
{
    /**
     * @var UserRepositoryInterface
     */
    private $userRepository;

    public function __construct(UserRepositoryInterface $userRepository)
    {
        $this->userRepository = $userRepository;
    }

    /**
     * Inserts in the UserDTO into the Database
     *
     * @param   UserDTO     $user
     * @param   string      $confirmPassword
     * @return  bool        true on success, false if password mismatch or username is taken
     */
    public function register(UserDTO $user,
                             string $confirmPassword): bool
    {
        if ($user->getPassword() !== $confirmPassword) {
            return false;
        }

        if (null !== $this->userRepository->findOneByUsername($user->getUsername())) {
            return false;
        }

        $user->setPassword(password_hash($user->getPassword(), PASSWORD_BCRYPT));

        return $this->userRepository->insert($user);
    }

    /**
     * Tries to log the user in by checking
     * if it exists and passwords match
     *
     * @param   string          $username
     * @param   string          $password
     * @return  UserDTO|null
     */
    public function login(string $username,
                          string $password): ?UserDTO
    {
        if (null === $user = $this->userRepository->findOneByUsername($username)) {
            return null;
        }

        $hashedPassword = $user->getPassword();
        if (true === password_verify($password, $hashedPassword)) {
            return $user;
        }

        return null;
    }

    /**
     * Returns all Users from the database
     * to be used in a Template
     *
     * @return \Generator | UserDTO[]
     */
    public function viewAll(): \Generator
    {
        return $this->userRepository->findAll();
    }

    /**
     * Tries to edit the profile
     * of the current User
     *
     * @param   UserDTO     $user
     * @return  bool        true on success, false if new username is taken
     */
    public function editProfile(UserDTO $user): bool
    {
        if (null !== $this->userRepository->findOneByUsername($user->getUsername())) {
            return false;
        }

        $user->setPassword(password_hash($user->getPassword(), PASSWORD_BCRYPT));

        return $this->userRepository->update($user, $_SESSION['id']);
    }

    /**
     * Returns the current logged User
     *
     * @return UserDTO|null
     */
    public function getCurrentUser(): ?UserDTO
    {
        if (!isset($_SESSION['id'])) {
            return null;
        }

        return $this->userRepository->findOneById($_SESSION['id']);
    }
}
