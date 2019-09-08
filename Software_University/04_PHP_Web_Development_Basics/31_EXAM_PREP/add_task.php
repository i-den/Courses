<?php

require_once 'common.php';

$taskRepository = new \TaskManagement\Repository\TaskRepository($database, $dataBinder);
$taskService = new \TaskManagement\Service\TaskService($taskRepository);

$categoryRepository = new \TaskManagement\Repository\CategoryRepository($database, $dataBinder);
$categoryService = new \TaskManagement\Service\CategoryService($categoryRepository);

$userService = new \TaskManagement\Service\UserService(new \TaskManagement\Repository\UserRepository($database));

$taskHandler = new \TaskManagement\Http\TaskHttpHandler($template, $dataBinder);
$taskHandler->add($taskService, $categoryService, $userService, $_POST);
