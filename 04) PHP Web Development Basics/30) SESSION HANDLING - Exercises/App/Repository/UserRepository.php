<?php


namespace Repository;


use Data\UserDTO;
use Database\DatabaseInterface;

class UserRepository implements UserRepositoryInterface
{
    /**
     * @var DatabaseInterface
     */
    private $database;

    public function __construct(DatabaseInterface $database)
    {
        $this->database = $database;
    }

    public function insert(UserDTO $user): bool
    {
        $this->database->prepare(
            "INSERT INTO `users` (`username`, `password`, `first_name`, `last_name`, `born_on`) VALUES (?, ?, ?, ?, ?)"
        )->execute(array(
            $user->getUsername(),
            $user->getPassword(),
            $user->getFirstName(),
            $user->getLastName(),
            $user->getBornOn()
        ));

        return true;
    }

    public function findOneById(int $id): ?UserDTO
    {
        return $this->database->prepare(
            "SELECT `id`, `username`, `password`, `first_name` AS `firstName`, `last_name` AS `lastName`, `born_on` AS `bornOn` FROM `users` WHERE `id` = ?"
        )->execute(array(
            $id
        ))->fetch(UserDTO::class)
            ->current();
    }

    public function findOneByUsername(string $username): ?UserDTO
    {
        return $this->database->prepare(
            "SELECT `id`, `username`, `password`, `first_name` AS `firstName`, `last_name` AS `lastName`, `born_on` AS `bornOn` FROM `users` WHERE `username` = ?"
        )->execute(array(
            $username
        ))->fetch(UserDTO::class)
            ->current();
    }

    public function findAll(): \Generator
    {
        return $this->database->prepare(
            "SELECT `id`, `username`, `password`, `first_name` AS `firstName`, `last_name` AS `lastName`, `born_on` AS `bornOn` FROM `users`"
        )->execute()
            ->fetch(UserDTO::class);
    }

    public function update(UserDTO $user, int $id): bool
    {
        $this->database->prepare(
            "UPDATE `users` SET `username` = ?, `password` = ?, `first_name` = ?, `last_name` = ?, `born_on` = ? WHERE `id` = ?"
        )->execute(array(
            $user->getUsername(),
            $user->getPassword(),
            $user->getFirstName(),
            $user->getLastName(),
            $user->getBornOn(),
            $id
        ));

        return true;
    }

    public function delete(int $id): bool
    {
        $this->database->prepare(
            "DELETE FROM `users` WHERE `id` = ?"
        )->execute(array(
           $id
        ));

        return true;
    }
}
