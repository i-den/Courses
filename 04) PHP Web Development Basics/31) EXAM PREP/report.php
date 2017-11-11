<?php
require_once 'common.php';
$taskHttpHandler = new \TaskManagement\Http\TaskHttpHandler($template, $dataBinder);
$categoryService = new \TaskManagement\Service\CategoryService(new \TaskManagement\Repository\CategoryRepository($database));
$taskHttpHandler->report($categoryService);