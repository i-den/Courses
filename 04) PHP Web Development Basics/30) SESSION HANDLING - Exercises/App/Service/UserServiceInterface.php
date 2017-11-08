<?php


namespace Service;


use Data\UserDTO;

interface UserServiceInterface
{
    public function register(UserDTO $user, string $confirmPassword);

    public function login(string $username, string $password): UserDTO;

    public function isLogged(): bool;

    /**
     * @return \Generator | UserDTO[]
     */
    public function viewAll(): \Generator;

    public function editProfile(UserDTO $user);

    public function getCurrentUser(): ?UserDTO;
}