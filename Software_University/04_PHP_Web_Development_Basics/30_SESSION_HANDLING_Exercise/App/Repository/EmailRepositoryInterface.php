<?php


namespace Repository;


use Data\EmailDTO;

interface EmailRepositoryInterface
{
    public function insert(EmailDTO $email);

    public function findEmailByAddr(string $emailAddress): ?EmailDTO;

    public function findEmailById(string $id): ?EmailDTO;

    public function findEmailsByUserId(string $id): \Generator;

    public function updateEmail(EmailDTO $email, string $id);

    public function getAmountOfEmails(): int;

    public function deleteEmail($id);
}