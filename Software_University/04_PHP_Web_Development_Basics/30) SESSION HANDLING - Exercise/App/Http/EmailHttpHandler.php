<?php


namespace Http;


use Data\EmailDTO;
use Data\ErrorDTO;
use Service\EmailServiceInterface;
use Service\UserServiceInterface;

class EmailHttpHandler extends HttpHandler
{

    /**
     * Display All Emails for the Current User if
     *
     * - he is logged in
     *
     * Paginates
     *
     * @param UserServiceInterface $userService
     * @param EmailServiceInterface $emailService
     * @param array $requestData
     */
    public function viewAll(UserServiceInterface $userService,
                            EmailServiceInterface $emailService,
                            array $requestData = [])
    {
        // If the user isn't logged redirect to the login page
        if (!$userService->isLogged()) {
            $this->redirect('login.php');
        }

        // Blank request without page being specified, set it to the first one
        if (!isset($requestData['page'])) {
            $requestData['page'] = 1;
        }

        // If the page is set but it's not an integer - set it to the first one
        if (!filter_var($requestData['page'], FILTER_VALIDATE_INT)) {
            $requestData['page'] = 1;
        }

        // Build a PageDTO to help with pagination
        $requestData['page'] = intval($requestData['page']);
        $pageDTO = $emailService->buildEmailPageDTO($requestData['page']);

        // If the page isn't within limits - set it to 1
        if ($requestData['page'] > $pageDTO->getMaximumPages()) {
            $requestData['page'] = 1;
            $pageDTO = $emailService->buildEmailPageDTO($requestData['page']);
        }

        try {
            // Get Current Logged User
            $currentLoggedUser = $userService->getCurrentUser();

            // Get all Emails belonging to the Current Logged User and display them
            $this->render(
                'email/all',
                $emailService->viewAll($currentLoggedUser->getId()),
                $pageDTO
            );
        } catch (\Exception $exception) {
            // Session went wrong :/
            $this->render(
                'app/error',
                new ErrorDTO($exception->getMessage())
            );
        }
    }

    /**
     * Responsible for handling requests made to create a new Email
     *
     * Displays the form to add new email or tries to add the email
     * if the user is logged
     *
     * @param UserServiceInterface $userService
     * @param EmailServiceInterface $emailService
     * @param array $formData
     */
    public function newEmail(UserServiceInterface $userService,
                             EmailServiceInterface $emailService,
                             array $formData = [])
    {
        // If the user isn't logged - redirect to login.php
        if (!$userService->isLogged()) {
            $this->redirect('login.php');
        }

        if (isset($formData['addEmail'])) {
            // If the Form is submitted - handle it and try to insert new email
            $this->handleNewEmail($userService, $emailService, $formData);
        } else {
            // Otherwise render the Form for adding new emails
            $this->render('email/new');
        }
    }


    /**
     * Handles requests to update the current Email
     *
     * - user needs to be logged
     * && have ownership of the email
     *
     * - email needs to be existing
     * && id set in the request
     *
     * @param UserServiceInterface $userService
     * @param EmailServiceInterface $emailService
     * @param array $requestData
     * @param array $formData
     */
    public function update(UserServiceInterface $userService,
                           EmailServiceInterface $emailService,
                           array $requestData = [],
                           array $formData = [])
    {
        // Verifies that the user is logged and that the Email ID is present in the request
        $this->verifyEmailForDisplay($userService, $requestData);

        if (isset($formData['update'])) {
            // Form for update is set - try to update with the submitted information
            $this->handleUpdateEmailProcess($userService, $emailService, $requestData, $formData);
        } else {
            // Display the Email Information to the edit Template
            $this->displayEmailById($userService, $emailService, $requestData, 'email/edit');
        }
    }


    /**
     * Handles requests to delete the current user's email
     *
     * - must have ownership
     * - email ID in the request
     *
     * @param UserServiceInterface $userService
     * @param EmailServiceInterface $emailService
     * @param array $requestData
     * @param array $formData
     */
    public function deleteEmail(UserServiceInterface $userService,
                                EmailServiceInterface $emailService,
                                array $requestData = [],
                                array $formData = [])
    {
        // Verifies that the user is logged and that the Email ID is present in the request
        $this->verifyEmailForDisplay($userService, $requestData);

        if (isset($formData['delete'])) {
            // If form for deletion is submitted - try to delete the email from the Database
            $this->handleDeleteEmailProcess($userService, $emailService, $requestData);
        } else {
            // Otherwise display the email's information for the deletion to be confirmed
            $this->displayEmailById($userService, $emailService, $requestData, 'email/delete');
        }
    }

    /**
     * Handles form submission for inserting new Emails
     * into the Database
     *
     * @param UserServiceInterface $userService
     * @param EmailServiceInterface $emailService
     * @param array $formData
     */
    private function handleNewEmail(UserServiceInterface $userService,
                                    EmailServiceInterface $emailService,
                                    array $formData = [])
    {
        // If form is submitted but no new email address is specified - ask to fill in the form
        if (empty($formData['email'])) {
            $this->render(
                'app/error',
                new ErrorDTO('Please fill in the form')
            );
        }

        try {
            // Get the Current Logged User
            $user = $userService->getCurrentUser();
            // Create a new EmailDTO holding all the data for the email which will be inserted
            $email = EmailDTO::create(htmlspecialchars($formData['email']), $user->getId());
            // Try to insert the email and redirect the User to view all of his emails
            $emailService->addEmail($email);
            $this->redirect('all-emails.php');
        } catch (\Exception $exception) {
            $this->render(
                'app/error',
                new ErrorDTO($exception->getMessage())
            );
        }

    }

    /**
     * Verifies that the current Email can be viewed
     * either for update or deletion by the Current Logged User
     *
     * - needs to be logged
     * - the email ID must be present in the $_GET SG
     *
     * @param UserServiceInterface $userService
     * @param array $requestData
     */
    private function verifyEmailForDisplay(UserServiceInterface $userService,
                                           array $requestData = [])
    {
        if (!$userService->isLogged()) {
            $this->redirect('login.php');
        }

        if (!isset($requestData['id'])) {
            $this->render(
                'app/error',
                new ErrorDTO('No email specified')
            );
        }
    }

    /**
     * Tries to display the current Email from the Database
     * to the User if
     *
     * - he's logged
     * && has ownership
     * && email with that ID exists
     *
     * @param UserServiceInterface $userService
     * @param EmailServiceInterface $emailService
     * @param array $requestData
     * @param string $templateName
     */
    private function displayEmailById(UserServiceInterface $userService,
                                      EmailServiceInterface $emailService,
                                      array $requestData = [],
                                      string $templateName)
    {
        try {
            // Tries to get the Email's information from the Database and displays them
            $emailForUpdate = $emailService->getEmailForUpdate($userService, $requestData['id']);
            $this->render(
                $templateName,
                $emailForUpdate
            );
        } catch (\Exception $exception) {
            // Session went wrong, Email with that ID doesn't exists, or Ownership issue
            $this->render(
                'app/error',
                new ErrorDTO($exception->getMessage())
            );
        }
    }

    /**
     * Tries to update the Email with the submitted form's information
     *
     * - form must be filled
     * - User must have ownership of the email
     * - new email must not be taken
     *
     * @param UserServiceInterface $userService
     * @param EmailServiceInterface $emailService
     * @param array $requestData
     * @param array $formData
     */
    private function handleUpdateEmailProcess(UserServiceInterface $userService,
                                              EmailServiceInterface $emailService,
                                              array $requestData = [],
                                              array $formData = [])
    {
        // If form is submitted but the email field is empty - throw an error
        if (empty($formData['email'])) {
            $this->render(
                'app/error',
                new ErrorDTO('Please fill in the form')
            );
        }

        try {
            // Check if the email is eligible to be updated
            $emailService->verifyOwnership($userService, $requestData['id']);
            // Create the new EmailDTO from the filled form
            $emailForUpdate = EmailDTO::create($formData['email'], $userService->getCurrentUser()->getId());
            // Try to update and redirect the user to View All Emails page
            $emailService->update($emailForUpdate, $requestData);
            $this->redirect('all-emails.php?page=1');
        } catch (\Exception $exception) {
            // If email already exists for another user - throw an error
            $this->render(
                'app/error',
                new ErrorDTO($exception->getMessage())
            );
        }

    }


    /**
     * Tries to delete the email if
     *
     * - user has ownership
     *
     * @param UserServiceInterface $userService
     * @param EmailServiceInterface $emailService
     * @param array $requestData
     */
    private function handleDeleteEmailProcess(UserServiceInterface $userService,
                                              EmailServiceInterface $emailService,
                                              array $requestData = [])
    {
        try {
            // Verifies ownership of the email and that it exists
            $emailService->verifyOwnership($userService, $requestData['id']);
            // Tries to delete email and redirects to view all emails
            $emailService->deleteEmail($requestData['id']);
            $this->redirect('all-emails.php?page=1');
        } catch (\Exception $exception) {
            // Wrong login, ownership or email ID
            $this->render(
                'app/error',
                new ErrorDTO($exception->getMessage())
            );
        }
    }
}