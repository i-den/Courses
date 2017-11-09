<?php

use Http\UserHttpHandler;
use Repository\UserRepository;
use Service\UserService;

require_once 'common.php';

$userRepository = new UserRepository($database);
$userService = new UserService($userRepository);

$userHttpHandler = new UserHttpHandler($template, $dataBinder);
$userHttpHandler->all($userService, $_GET);