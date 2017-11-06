<?php


namespace Http;


use Data\UserDTO;
use Service\UserServiceInterface;

class UserHttpHandler extends HttpHandlerAbstract
{
    public function register(UserServiceInterface $userService,
                             array $formData = array())
    {
        if (isset($formData['register'])) {

            $this->handleRegisterProcess($userService, $formData);

        } else {

            $this->render('user/register');

        }
    }

    public function login(UserServiceInterface $userService,
                          array $formData = array())
    {
        if (isset($formData['login'])) {

            $this->handleLoginProcess($userService, $formData);

        } else {

            $this->render('user/login');

        }
    }

    private function handleRegisterProcess(UserServiceInterface $userService,
                                           array $formData = array())
    {
        $result = $userService->register(

            UserDTO::create(
                $formData['username'],
                $formData['password'],
                $formData['first_name'],
                $formData['last_name'],
                $formData['born_on']
            ),

            $formData['confirm_password']
        );

        $this->redirect('login.php');
    }

    private function handleLoginProcess(UserServiceInterface$userService,
                                        array $formData = array())
    {
        $loggedUser = $userService->login($formData['username'], $formData['password']);

        if (null !== $loggedUser) {
            $_SESSION['id'] = $loggedUser->getId();
            $this->redirect('profile.php');
        }
    }
}