<?php


namespace Repository;


use Data\UserDTO;
use Database\DatabaseInterface;
use Database\PDODatabase;

class UserRepository implements UserRepositoryInterface
{
    /**
     * @var DatabaseInterface
     */
    private $database;

    public function __construct(DatabaseInterface $database)
    {
        $this->setPdoDatabase($database);
    }

    public function findOne(int $id): UserDTO
    {

    }

    public function findOneByUsername(string $username): ?UserDTO
    {
        return $this->database->query(
            "SELECT `id`, `username`, `password`, `first_name` AS `firstName`, `last_name` AS `lastName`, `born_on` AS `bornOn` FROM `users` WHERE `username` = ?"
        )->execute(array(
           $username
        ))->fetchAll(UserDTO::class)
        ->current();
    }

    /** @return \Generator | UserDTO[] */
    public function findAll(): \Generator
    {
        // TODO: Implement findAll() method.
    }

    public function update(UserDTO $user): bool
    {
        // TODO: Implement update() method.
    }

    public function insert(UserDTO $user): bool
    {
        $this->database->query(

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

    public function delete(int $id): bool
    {
        // TODO: Implement delete() method.
    }

    private function setPdoDatabase(DatabaseInterface $database): UserRepositoryInterface
    {
        $this->database = $database;
        return $this;
    }
}