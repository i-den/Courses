<?php

require_once './geography-db.php';
require_once './MyPDO.php';

try {
    $db = new MyPDO("mysql:dbname=$db_name;host=$db_host", $db_user, $db_pass);
    $db->setErrorException();
    $population = 1000000000;

    $countries = $db->query("
              SELECT `a`.`country_name`
              FROM `countries`  AS `a`,
                   `continents` AS `b`
              WHERE `a`.`continent_code` = `b`.`continent_code`
              AND `a`.`population` > $population",
        PDO::FETCH_ASSOC);

    foreach ($countries as $country) {
        echo $country['country_name'] . PHP_EOL;
    }

    $countries = null;
    $db         = null;
} catch (PDOException $e) {
    echo $e->getMessage();
}
