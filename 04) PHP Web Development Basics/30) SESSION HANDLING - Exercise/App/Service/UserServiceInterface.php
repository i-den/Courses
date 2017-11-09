<?php


namespace Service;


use Data\PageDTO;
use Data\UserDTO;

interface UserServiceInterface
{
    public function register(UserDTO $user, string $confirmPassword);

    public function login(string $username, string $password): UserDTO;

    public function isLogged(): bool;

    /**
     * @param int $page
     * @return UserDTO[]|\Generator
     */
    public function viewAll(int $page): \Generator;

    public function buildUserPageDTO(int $currentPage): PageDTO;

    public function editProfile(UserDTO $user);

    public function getCurrentUser(): ?UserDTO;
}