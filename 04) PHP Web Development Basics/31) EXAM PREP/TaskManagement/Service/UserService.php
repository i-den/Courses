<?php


namespace TaskManagement\Service;


use TaskManagement\DTO\UserDTO;
use TaskManagement\Repository\UserRepositoryInterface;

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

    public function getCurrentUser(): UserDTO
    {
        if (!isset($_SESSION['username'])) {
            throw new \Exception('No current user!');
        }

        return $this->userRepository->findOneByUsername($_SESSION['username']);
    }

    public function login(string $username, string $password): bool
    {
        $userFromDb = $this->userRepository->findOneByUsername($username);

        if (null === $userFromDb) {
            throw new \Exception('Username not found!');
        }

        $passwordHash = $userFromDb->getPassword();
        if (!password_verify($password, $passwordHash)) {
            throw new \Exception('Passwords mismatch!');
        }

        $_SESSION['username'] = $userFromDb->getUsername();
        $_SESSION['id'] = $userFromDb->getId();
        return true;
    }

    public function register(UserDTO $user, string $confirmPassword): bool
    {
        if ($user->getPassword() !== $confirmPassword) {
            throw new \Exception('Passwords mismatch!');
        }

        $userFromDb = $this->userRepository->findOneByUsername($user->getUsername());

        if (null !== $userFromDb) {
            throw new \Exception('User already exists');
        }

        $plainPassword = $user->getPassword();
        $passwordHash = password_hash($plainPassword, PASSWORD_BCRYPT);
        $user->setPassword($passwordHash);

        return $this->userRepository->insert($user);
    }
}