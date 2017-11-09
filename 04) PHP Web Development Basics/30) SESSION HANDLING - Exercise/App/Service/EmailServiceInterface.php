<?php


namespace Service;


use Data\EmailDTO;
use Data\PageDTO;

interface EmailServiceInterface
{

    public function viewAll(string $id): \Generator;

    public function buildEmailPageDTO(int $currentPage): PageDTO;

    public function addEmail(EmailDTO $email);

    public function getEmailForUpdate(UserServiceInterface $userService, string $emailId): EmailDTO;

    public function update(EmailDTO $emailForUpdate, array $requestData);

    public function verifyOwnership(UserServiceInterface $userService, string $emailId);

    public function deleteEmail(string $id);
}