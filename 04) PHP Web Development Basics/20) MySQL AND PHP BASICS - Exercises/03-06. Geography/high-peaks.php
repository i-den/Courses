<?php

require_once './geography-db.php';
require_once './MyPDO.php';

try {

    $db = new MyPDO("mysql:dbname=$db_name;host=$db_host;charset=utf8", $db_user, $db_pass);
    $db->setErrorException();
    $mountain = trim(fgets(STDIN));
    $elevation = 6700;

    $peaks = $db->query(
        "SELECT `peak_name`, `elevation`
                FROM `peaks`
                JOIN `mountains`
                ON `peaks`.`mountain_id` = `mountains`.`id`
                WHERE `mountain_range` = '$mountain'
                AND `elevation` > '$elevation'",
        PDO::FETCH_ASSOC
    );

    foreach ($peaks as $i => $peak) {
        echo $peak['peak_name'] . ',' . $peak['elevation'] . PHP_EOL;
    }

} catch (PDOException $e) {
    echo $e->getMessage();
}