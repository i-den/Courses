<?php

session_start();

spl_autoload_register(function ($className) {
    $classFile = str_replace('\\', DIRECTORY_SEPARATOR, $className) . '.php';
    require_once __DIR__  . DIRECTORY_SEPARATOR . $classFile;
});

//spl_autoload_register();

$dbInfo = parse_ini_file('Config/db.ini');
$pdo = new PDO($dbInfo['dsn'], $dbInfo['user'], $dbInfo['pass']);
$database = new Database\PDODatabase($pdo);

$template = new \Core\Template();
$dataBinder = new \Core\DataBinder();