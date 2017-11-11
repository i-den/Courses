<?php

require_once 'common.php';

$homeHandler = new \TaskManagement\Http\HomeHttpHandler($template, $dataBinder);
$taskRepository = new \TaskManagement\Repository\TaskRepository($database, $dataBinder);
$taskService = new \TaskManagement\Service\TaskService($taskRepository);
$homeHandler->dashboard($taskService, $_GET);
