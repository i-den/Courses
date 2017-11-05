<?php
use Core\Template;
use Database\PDODatabase;

require_once '../vendor/autoload.php';

$template = new Template();

$dbIni = parse_ini_file('../app/Config/db.ini');
$pdo = new \PDO($dbIni['dsn'], $dbIni['user'], $dbIni['pass']);
$database = new PDODatabase($pdo);