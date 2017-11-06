<?php


namespace Service;


use Data\UserDTO;

interface UserServiceInterface
{
    public function register(UserDTO $user, string $confirmPassword): bool;

    public function login(string $username, string $password): ?UserDTO;

    /**
     * @return \Generator | UserDTO[]
     */
    public function viewAll(): \Generator;

    public function editProfile(UserDTO $user): bool;

    public function getCurrentUser(): ?UserDTO;
}