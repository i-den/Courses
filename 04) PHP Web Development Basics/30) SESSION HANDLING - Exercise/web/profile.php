<?php

use Http\UserHttpHandler;

require_once 'common.php';

$userHttpHandler = new UserHttpHandler($template, $dataBinder);
$userHttpHandler->profile($userService, $_POST);