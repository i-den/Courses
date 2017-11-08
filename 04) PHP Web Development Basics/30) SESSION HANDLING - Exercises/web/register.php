<?php

use Http\UserHttpHandler;

require_once 'common.php';

$userHttpHandler = new UserHttpHandler($template, $dataBinder);
$userHttpHandler->register($userService, $_POST);
