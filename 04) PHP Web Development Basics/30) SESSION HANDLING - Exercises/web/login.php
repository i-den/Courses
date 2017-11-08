<?php

use Http\UserHttpHandler;

include_once 'common.php';

$userHttpHandler = new UserHttpHandler($template, $dataBinder);
$userHttpHandler->login($userService, $_POST);
