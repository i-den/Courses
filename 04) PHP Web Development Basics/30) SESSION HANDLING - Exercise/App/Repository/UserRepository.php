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

    /**
     * Inserts an UserDTO object in the Database
     *
     * @param UserDTO $user
     * @return bool
     */
    public function insert(UserDTO $user)
    {
        $this->database->prepare(
            "INSERT INTO `users` (`username`, `password`, `first_name`, `last_name`, `born_on`) VALUES (?, ?, ?, ?, ?) "
        )->execute(array(
            $user->getUsername(),
            $user->getPassword(),
            $user->getFirstName(),
            $user->getLastName(),
            $user->getBornOn()
        ));
    }

    /**
     * Returns an UserDTO object from the Database
     * that matches the given id or null if none found
     *
     * @param int $id
     * @return UserDTO|null
     */
    public function findOneById(int $id): ?UserDTO
    {
        return $this->database->prepare(
            "SELECT `id`,  `username`, `password`, `first_name` AS `firstName`, `last_name` AS `lastName`, `born_on` AS `bornOn` FROM `users` WHERE `id` = ?"
        )->execute(array(
            $id
        ))->fetchObject(UserDTO::class)
            ->current();
    }

    /**
     * Returns an UserDTO object from the Database
     * that matches the given param $username
     * or null if none found
     *
     * @param string $username
     * @return UserDTO|null
     */
    public function findOneByUsername(string $username): ?UserDTO
    {
        return $this->database->prepare(
            "SELECT `id`, `username`, `password`, `first_name` AS `firstName`, `last_name` AS `lastName`, `born_on` AS `bornOn` FROM `users` WHERE `username` = ?"
        )->execute(array($username))
            ->fetchObject(UserDTO::class)
            ->current();
    }

    public function findAll(string $startPage, string $usersPerPage): \Generator
    {
        return $this->database->prepare(
            "SELECT `id`, `username`, `password`, `first_name` AS `firstName`, `last_name` AS `lastName`, `born_on` AS `bornOn`FROM  `users`  LIMIT $startPage, $usersPerPage"
        )->execute()
            ->fetchObject(UserDTO::class);
    }

    public function getAmountOfUsers(): int
    {
        return $this->database->prepare(
            "SELECT COUNT(`id`) AS `count` FROM `users`"
        )->execute()
            ->fetchRow('count');
    }


    /**
     * Updates an User profile
     *
     * @param UserDTO $user
     * @param int $id
     */
    public function update(UserDTO $user, int $id)
    {
        $this->database->prepare(
            "UPDATE `users` SET `username` = ?, `password` = ?, `first_name` = ?, `last_name` = ?, `born_on` = ? WHERE `id` = ?"
        )->execute(array(
                $user->getUsername(),
                $user->getPassword(),
                $user->getFirstName(),
                $user->getLastName(),
                $user->getBornOn(),
                $id)
        );
    }

    public function delete(int $id)
    {
        $this->database->prepare(
            "DELETE FROM `users` WHERE `id` = ?"
        )->execute(array($id));
    }
}
