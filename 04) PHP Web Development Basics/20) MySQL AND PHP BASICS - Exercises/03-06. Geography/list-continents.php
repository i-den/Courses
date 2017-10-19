<?php

require_once './geography-db.php';
require_once './MyPDO.php';

try {
    $db = new MyPDO("mysql:dbname=$db_name;host=$db_host", $db_user, $db_pass);
    $result = array();
    $db->setErrorException();

    $continents = $db->query("SELECT `continent_code`, `continent_name` FROM `continents`", PDO::FETCH_ASSOC);

    foreach ($continents as $continent) {
        $result[] = "{$continent['continent_code']} ({$continent['continent_name']})";
    }
    $continents = null;
    $db         = null;

    echo implode(', ', $result);
} catch (PDOException $e) {
    echo $e->getMessage();
}
