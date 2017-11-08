<?php

use Core\DataBinder;
use Core\Template;
use Database\Database;
use Repository\UserRepository;
use Service\UserService;

session_start();

spl_autoload_register(function($className) {
    $classFile = str_replace('\\', DIRECTORY_SEPARATOR, $className) . '.php';
    require_once __DIR__ . DIRECTORY_SEPARATOR . '..' . DIRECTORY_SEPARATOR . 'App' . DIRECTORY_SEPARATOR . $classFile;
});

$dbInfo = parse_ini_file(__DIR__ . DIRECTORY_SEPARATOR . '..' . DIRECTORY_SEPARATOR . 'App' . DIRECTORY_SEPARATOR . 'Config' . DIRECTORY_SEPARATOR . 'db.ini');

$pdo = new PDO($dbInfo['dsn'], $dbInfo['user'], $dbInfo['pass']);
$database = new Database($pdo);

$userRepository = new UserRepository($database);
$userService = new UserService($userRepository);

$template = new Template();
$dataBinder = new DataBinder();
