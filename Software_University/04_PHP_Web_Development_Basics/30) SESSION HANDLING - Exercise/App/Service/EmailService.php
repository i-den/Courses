<?php


namespace Service;


use Data\EmailDTO;
use Data\PageDTO;
use Repository\EmailRepositoryInterface;

class EmailService implements EmailServiceInterface
{
    const EMAILS_PER_PAGE = 3;

    /**
     * @var EmailRepositoryInterface
     */
    private $emailRepository;

    public function __construct(EmailRepositoryInterface $emailRepository)
    {
        $this->emailRepository = $emailRepository;
    }

    /**
     * Return all emails for the Template
     *
     * @param string $id
     * @return \Generator
     */
    public function viewAll(string $id): \Generator
    {
        return $this->emailRepository->findEmailsByUserId($id);
    }

    public function buildEmailPageDTO(int $currentPage): PageDTO
    {
        $totalEmails = $this->emailRepository->getAmountOfEmails();
        $maximumEmails = ceil($totalEmails / self::EMAILS_PER_PAGE);

        return new PageDTO($currentPage, $maximumEmails);
    }

    /**
     * Inserts an Email into the Database if
     *
     * - email doesn't exist already
     *
     * @param EmailDTO $email
     * @throws \Exception
     */
    public function addEmail(EmailDTO $email)
    {
        // Try to find an email from the Database with the same Email Address
        $emailAddr = $this->emailRepository->findEmailByAddr($email->getEmail());

        // If found - throw an error - it's already taken
        if (null !== $emailAddr) {
            throw new \Exception('Email already exists!');
        }

        // If it's free - insert it for the Current Logged User
        $this->emailRepository->insert($email);
    }

    public function getEmailForUpdate(UserServiceInterface $userService, string $emailId): EmailDTO
    {
        $this->verifyOwnership($userService, $emailId);
        return $this->emailRepository->findEmailById($emailId);
    }

    public function verifyOwnership(UserServiceInterface $userService, string $emailId)
    {
        $currentLoggedUser = $userService->getCurrentUser();

        if (null === $currentLoggedUser) {
            throw new \Exception('Something went wrong');
        }

        $emailToVerify = $this->emailRepository->findEmailById($emailId);

        if (null === $emailToVerify) {
            throw new \Exception('Email with that ID Doesn\'t exist');
        }

        if ($emailToVerify->getUserId() !== $currentLoggedUser->getId()) {
            throw new \Exception('You don\'t have rights over this email!');
        }
    }

    public function update(EmailDTO $emailForUpdate, array $requestData)
    {
        $emailExists = $this->emailRepository->findEmailByAddr($emailForUpdate->getEmail());

        if (null !== $emailExists) {
            throw new \Exception('Email already exists');
        }

        $this->emailRepository->updateEmail($emailForUpdate, $requestData['id']);
    }



    public function deleteEmail(string $id)
    {
        $this->emailRepository->deleteEmail($id);
    }
}