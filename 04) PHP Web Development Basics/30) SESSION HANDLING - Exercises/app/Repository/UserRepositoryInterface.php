<?php


namespace Repository;


use Data\UserDTO;

interface UserRepositoryInterface
{
    public function findOne(int $id): UserDTO;

    public function findOneByUsername(string $username): ?UserDTO;

    /** @return \Generator | UserDTO[] */
    public function findAll(): \Generator;

    public function update(UserDTO $user): bool;

    public function insert(UserDTO $user): bool;

    public function delete(int $id): bool;
}