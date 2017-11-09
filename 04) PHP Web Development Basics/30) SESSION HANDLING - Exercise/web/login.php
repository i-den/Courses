<?php

use Http\UserHttpHandler;
use Repository\UserRepository;
use Service\UserService;

include_once 'common.php';

$userRepository = new UserRepository($database);
$userService = new UserService($userRepository);

$userHttpHandler = new UserHttpHandler($template, $dataBinder);
$userHttpHandler->login($userService, $_POST);
