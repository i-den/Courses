<?php

/**
 * Autoloading via Composer
 */
use Core\DataBinder;
use Core\Template;
use Database\Database;
use Http\UserHttpHandler;
use Repository\UserRepository;
use Service\UserService;

require_once '../vendor/autoload.php';

session_start();

$databaseConfig = parse_ini_file('../App/Config/db.ini');
$pdo = new PDO($databaseConfig['dsn'], $databaseConfig['user'], $databaseConfig['pass']);
$database = new Database($pdo);

$userRepository = new UserRepository($database);

$userService = new UserService($userRepository);

$template = new Template();
$dataBinder = new DataBinder();
$httpHandler = new UserHttpHandler($template, $dataBinder);
