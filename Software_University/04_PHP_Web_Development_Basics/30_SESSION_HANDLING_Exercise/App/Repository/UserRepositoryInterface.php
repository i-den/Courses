<?php


namespace Repository;


use Data\UserDTO;

interface UserRepositoryInterface
{
    public function insert(UserDTO $user);

    public function findOneById(int $id): ?UserDTO;

    public function findOneByUsername(string $username): ?UserDTO;

    public function findAll(string $startPage, string $usersPerPage): \Generator;

    public function getAmountOfUsers(): int;

    public function update(UserDTO $user, int $id);

    public function delete(int $id);
}
