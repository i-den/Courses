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

    public function register(UserDTO $user, $confirmPassword): bool
    {
        if ($user->getPassword() != $confirmPassword) {
            return false;
        }

        if (null !== $this->userRepository->findOneByUsername($user->getUsername())) {
            return false;
        }

        $plainPassword = $user->getPassword();
        $passwordHash = password_hash($plainPassword, PASSWORD_BCRYPT);
        $user->setPassword($passwordHash);

        return $this->userRepository->insert($user);
    }

    public function login(string $username,
                          string $password): ?UserDTO
    {
        if (null == $user = $this->userRepository->findOneByUsername($username)) {
            return null;
        }

        $password = $user->getPassword();

        if (true == password_verify($user->getPassword(),$password)) {
            return $user;
        }

        return null;
    }

    public function editProfile($id, UserDTO $user): bool
    {
        // TODO: Implement editProfile() method.
    }

    /** @return \Generator | UserDTO[] */
    public function viewAll(): \Generator
    {
        // TODO: Implement viewAll() method.
    }

    public function isLogged(): bool
    {
        // TODO: Implement isLogged() method.
    }

    public function getCurrentUser(): ?UserDto
    {
        // TODO: Implement getCurrentUser() method.
    }
}