<?php

declare(strict_types=1);

// $db = new mysqli('127.0.0.1', 'root', 'pass123', 'geography');

require_once './db-config.php';

$db = new PDO("mysql:dbname={$db_name};host=$db_host", $db_user, $db_password);

$continents = $db->query("SELECT * FROM `continents`", PDO::FETCH_ASSOC);

foreach ($continents as $i => $continent) {
    print_r($continent);
    echo PHP_EOL;
}
