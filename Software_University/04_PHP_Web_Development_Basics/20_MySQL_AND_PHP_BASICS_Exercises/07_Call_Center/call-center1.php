<?php

declare(strict_types=1);

require_once './geography-db.php';
require_once './MyPDO.php';

try {
    $db = new MyPDO("mysql:dbname=$db_name;dbhost=$db_host;charset=utf8", $db_user, $db_pass);

    while (true) {
        $input_param = trim(fgets(STDIN));

        if ($input_param == 'Bye') {
            exit('Good bye!');
        }

        $stmt = $db->query(
          "SELECT `country_name`, `capital`
                    FROM  `countries`
                    WHERE `iso_code`  = '$input_param'
                    OR    `country_name` = '$input_param'
                    OR    `country_code` = '$input_param'",
          PDO::FETCH_ASSOC
        );

        foreach ($stmt as $i => $iv) {
            echo 'Country: ' . $iv['country_name'] . PHP_EOL;
            echo 'Capital: ' . $iv['capital'] . PHP_EOL;
        }
    }
} catch (PDOException $e) {
    echo $e->getMessage();
}