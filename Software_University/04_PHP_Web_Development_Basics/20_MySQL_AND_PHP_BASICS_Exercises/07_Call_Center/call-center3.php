<?php

declare(strict_types=1);

require_once './geography-db.php';
require_once './MyPDO.php';

try {
    $db = new MyPDO("mysql:dbname=$db_name;dbhost=$db_host;charset=utf8", $db_user, $db_pass);
    $db->setErrorException();

    $input = trim(fgets(STDIN));
    $param = null;

    switch (mb_strlen($input)) {
        case 2:
            $param = 'country_code';
            break;
        case 3:
            $param = 'iso_code';
            break;
    }

    $countriesQuery = $db->query(
        "SELECT 
                  `country_name`, `capital`, `currencies`.`description`, `continents`.`continent_name`
                  FROM `countries`
                  JOIN `currencies`
                  ON countries.currency_code = currencies.currency_code
                  JOIN continents
                  ON countries.continent_code = continents.continent_code
                  WHERE `$param` = '$input'",
        PDO::FETCH_ASSOC
    );

    foreach ($countriesQuery as $currCountryInfo) {
        echo 'Country: ' . $currCountryInfo['country_name'] . PHP_EOL;
        echo 'Capital: ' . $currCountryInfo['capital'] . PHP_EOL;
        echo 'Currency: ' . $currCountryInfo['description'] . PHP_EOL;
        echo 'Continent: ' . $currCountryInfo['continent_name'] . PHP_EOL;
    }

    $isMtnCntr = $db->prepare(
        "SELECT *
                  FROM `mountains_countries`
                  WHERE `country_code` = '$input';"
    );
    $isMtnCntr->execute();
    if ($isMtnCntr->rowCount() > 0) {
        echo 'Forward customer for special offers!' . PHP_EOL;
    }

    $hasPeak = $db->prepare(
        "SELECT *
                  FROM `peaks` AS p
                    JOIN `mountains_countries` AS mc
                    ON p.mountain_id = mc.mountain_id
                    JOIN `countries` AS c
                    ON mc.country_code = c.country_code
                  WHERE `elevation` > 4000
                  AND c.country_code = '$input'"
    );
    $hasPeak->execute();
    if ($hasPeak->rowCount() > 0) {
        echo 'Show high mountain special equipment offers!' . PHP_EOL;
    }

} catch (PDOException $e) {
    echo $e->getMessage();
}

