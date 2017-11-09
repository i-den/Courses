<?php

use Http\EmailHttpHandler;
use Repository\EmailRepository;
use Repository\UserRepository;
use Service\EmailService;
use Service\UserService;

require_once 'common.php';

$emailRepository = new EmailRepository($database);
$emailService = new EmailService($emailRepository);

$userRepository = new UserRepository($database);
$userService = new UserService($userRepository);

$emailHttpHandler = new EmailHttpHandler($template, $dataBinder);
$emailHttpHandler->newEmail($userService, $emailService, $_POST);