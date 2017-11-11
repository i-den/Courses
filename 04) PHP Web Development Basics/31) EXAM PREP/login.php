<?php

require_once 'common.php';

$userRepository = new \TaskManagement\Repository\UserRepository($database);
$userService = new \TaskManagement\Service\UserService($userRepository);
$userHandler = new \TaskManagement\Http\UserHttpHandler($template, $dataBinder, $userService);
$userHandler->login($_POST);