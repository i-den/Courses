<?php
require_once 'common.php';
$taskRepository = new \TaskManagement\Repository\TaskRepository($database, $dataBinder);
$taskService = new \TaskManagement\Service\TaskService($taskRepository);
$taskHandler = new \TaskManagement\Http\TaskHttpHandler($template, $dataBinder);
$taskHandler->delete($taskService, $_GET);