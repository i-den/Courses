<?php


namespace Repository;


use Data\EmailDTO;
use Database\DatabaseInterface;

class EmailRepository implements EmailRepositoryInterface
{
    /**
     * @var DatabaseInterface
     */
    private $database;

    public function __construct(DatabaseInterface $database)
    {
        $this->database = $database;
    }

    public function insert(EmailDTO $email)
    {
        $this->database->prepare(
            "INSERT INTO `emails` (user_id, email) VALUES (?, ?)"
        )->execute(array(
            $email->getUserId(),
            $email->getEmail())
        );
    }

    public function findEmailByAddr(string $emailAddress): ?EmailDTO
    {
        return $this->database->prepare(
            "SELECT `id`, `user_id` AS `userId`, `email` FROM `emails` WHERE `email` = ?"
        )->execute(array($emailAddress))
            ->fetchObject(EmailDTO::class)
            ->current();
    }

    public function findEmailById(string $id): ?EmailDTO
    {
        return $this->database->prepare(
            "SELECT `id`, `user_id` AS `userId`, `email` FROM `emails` WHERE `id` = ?"
        )->execute(array($id))
            ->fetchObject(EmailDTO::class)
            ->current();
    }

    public function findEmailsByUserId(string $id): \Generator
    {
        return $this->database->prepare(
            "SELECT `id`, `user_id` AS `userId`, `email` FROM `emails` WHERE `user_id` = ?"
        )->execute(array($id))
            ->fetchObject(EmailDTO::class);
    }

    public function updateEmail(EmailDTO $email, string $id)
    {
        $this->database->prepare(
            "UPDATE `emails` SET `email` = ? WHERE `id` = ?"
        )->execute(array($email->getEmail(), $id));
    }

    public function getAmountOfEmails(): int
    {
        return $this->database->prepare(
            "SELECT COUNT(`id`) AS `count` FROM `emails`"
        )->execute()
            ->fetchRow('count');
    }

    public function deleteEmail($id)
    {
        $this->database->prepare(
            "DELETE FROM `emails` WHERE `id` = ?"
        )->execute(array($id));
    }
}