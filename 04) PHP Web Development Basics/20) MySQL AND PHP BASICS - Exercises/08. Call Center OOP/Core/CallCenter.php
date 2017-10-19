<?php


namespace Core;


use Config\Connection;

class CallCenter implements ICallCenter
{
    /** @var  Connection */
    private $database;

    private $problems;
    private $problemQuotes;

    public function __construct(Connection $database)
    {
        $this->setDatabase($database);
        $this->loadProblems();
    }

    public function startWork()
    {
        $problemNumber = $this->getInput();
        $input = trim(fgets(STDIN));
        switch ($problemNumber) {
            case 0:
                $this->handleFirstProblem($input);
                break;
            case 1:
                $this->handleSecondProblem($input);
                break;
            case 2:
                $this->handleThirdProblem($input);
                break;
            case 3:
                $this->handleFourthProblem($input);
                break;

        }
    }

    private function getInput(): int
    {
        echo 'Здравейте колеги, проверяващи как си прекарах четвъртък вечерта!' . PHP_EOL;
        for ($i = 0; $i < count($this->problems); $i++) {
            echo 'Натиснете ' . $i . ' за ' . $this->problems[$i] . PHP_EOL;
        }

        $problemNumber = null;
        while (true) {
            $problemNumber = trim(fgets(STDIN));

            if (is_numeric($problemNumber)
                && intval($problemNumber) >= 0
                && intval($problemNumber) < 10
            ) {
                break;
            }

            echo 'Я пробвай пак, с интче в границите тоа път..' . PHP_EOL;
        }

        echo 'Вие направихте грешния избор, а именно ' . $this->problems[$problemNumber] . PHP_EOL;
        echo $this->problemQuotes[$problemNumber];
        return $problemNumber;
    }

    private function handleFirstProblem($input)
    {
        while (true) {

            if ($input == 'Bye') {
                exit('Виж ми и другите задачки ^.^');
            }

            $countryQuery = $this->getDatabase()->prepare(
                "SELECT  `country_name`, `capital`
                      FROM    `countries`
                      WHERE   `iso_code`      = :input
                      OR      `country_name`  = :input
                      OR      `country_code`  = :input
                      LIMIT 0, 1"
            );

            $countryQuery->bindParam('input', $input);
            $countryQuery->execute();

            if ($countryQuery->rowCount() > 0) {
                $countryInfo = $countryQuery->fetch(\PDO::FETCH_ASSOC);
                echo 'Country: ' . $countryInfo['country_name'] . PHP_EOL;
                echo 'Capital: ' . $countryInfo['capital'] . PHP_EOL;
            } else {
                echo 'Нема такова дзвер "' . $input . '"' . PHP_EOL;
            }
            echo 'подай още или си хой с \'Bye\'' . PHP_EOL;
            $input = trim(fgets(STDIN));
        }
    }

    private function handleSecondProblem($input)
    {
        $filter_type = null;

        switch (mb_strlen($input)) {
            case 2:
                $filter_type = 'country_code';
                break;
            case 3:
                $filter_type = 'iso_code';
                break;
        }

        $countryInfo = $this->getDatabase()->prepare(
            "SELECT `c`.`country_name`, `c`.`capital`, `curr`.`description`, `cont`.`continent_name`
                        FROM `countries` AS `c`
                        JOIN `currencies` AS `curr`
                        ON c.currency_code = curr.currency_code
                        JOIN `continents` AS `cont`
                        ON c.continent_code = cont.continent_code
                        WHERE c.$filter_type = :input"
        );

        $countryInfo->bindParam('input', $input);
        $countryInfo->execute();

        if ($countryInfo->rowCount() > 0) {
            $country = $countryInfo->fetch(\PDO::FETCH_ASSOC);
            echo 'Country: ' . $country['country_name'] . PHP_EOL;
            echo 'Capital: ' . $country['capital'] . PHP_EOL;
            echo 'Currency: ' . $country['description'] . PHP_EOL;
            echo 'Continent: ' . $country['continent_name'] . PHP_EOL;
        } else {
            echo 'Замалко го намера т\'ва е..' . PHP_EOL;
        }
    }

    private function handleThirdProblem($input)
    {
        $countryInfo = $this->getDatabase()->prepare(
            "SELECT
                        `c`.`country_name`,
                        `c`.`capital`,
                        `curr`.`description`,
                        `cont`.`continent_name`
                      FROM `countries` AS `c`
                        JOIN `currencies` AS `curr`
                          ON `c`.`currency_code` = `curr`.`currency_code`
                        JOIN `continents` AS `cont`
                          ON `c`.`continent_code` = `cont`.`continent_code`
                        JOIN `mountains_countries`
                          ON c.country_code = mountains_countries.country_code
                      WHERE c.`country_code` = :input"
        );

        $countryInfo->bindParam('input', $input);
        $countryInfo->execute();

        if ($countryInfo->rowCount() > 0) {
            $country = $countryInfo->fetch(\PDO::FETCH_ASSOC);
            echo 'Country: ' . $country['country_name'] . PHP_EOL;
            echo 'Capital: ' . $country['capital'] . PHP_EOL;
            echo 'Currency: ' . $country['description'] . PHP_EOL;
            echo 'Continent: ' . $country['continent_name'] . PHP_EOL;
            echo 'Forward customer for special offers!' . PHP_EOL;
        } else {
            $this->handleSecondProblem($input);
        }
    }

    private function handleFourthProblem($input)
    {
        $countryInfo = $this->getDatabase()->prepare(
            "SELECT
                        `c`.`country_name`,
                        `c`.`capital`,
                        `curr`.`description`,
                        `cont`.`continent_name`
                      FROM `countries` AS `c`
                        JOIN `currencies` AS `curr`
                          ON `c`.`currency_code` = `curr`.`currency_code`
                        JOIN `continents` AS `cont`
                          ON `c`.`continent_code` = `cont`.`continent_code`
                        JOIN `mountains_countries` AS `mc`
                          ON c.country_code = `mc`.country_code
                        JOIN `peaks`
                          ON `mc`.mountain_id = `peaks`.`mountain_id`
                      WHERE c.`country_code` = :input
                      AND `peaks`.`elevation` > 4000;"
        );

        $countryInfo->bindParam('input', $input);
        $countryInfo->execute();

        if ($countryInfo->rowCount() > 0) {
            $country = $countryInfo->fetch(\PDO::FETCH_ASSOC);
            echo 'Country: ' . $country['country_name'] . PHP_EOL;
            echo 'Capital: ' . $country['capital'] . PHP_EOL;
            echo 'Currency: ' . $country['description'] . PHP_EOL;
            echo 'Continent: ' . $country['continent_name'] . PHP_EOL;
            echo 'Forward customer for special offers!' . PHP_EOL;
            echo 'Show high mountain special equipment offers!' . PHP_EOL;
        } else {
            $this->handleThirdProblem($input);
        }
    }

    private function loadProblems()
    {
        $this->problems = array(
            'задачка 7 - Call Center App',
            'задачка 7.1 - Add Currency and Continent',
            'задачка 7.2 - Customers in the Mountain',
            'задачка 7.3 - Special Ski Equipment'
        );
        $this->problemQuotes = array(
            'Цъкнете ми една рак.. [ country_name | country_code | iso_code | \'Bye\' ]: ' . PHP_EOL,
            'Подай ми [ country_code | iso_code ]' . PHP_EOL,
            'Моля един [ country_code | iso_code ]' . PHP_EOL,
            'Ти си, давай [ country_code | iso_code ]' . PHP_EOL
        );
    }

    /**
     * @return Connection
     */
    private function getDatabase(): Connection
    {
        return $this->database;
    }

    /**
     * @param Connection $database
     * @return CallCenter
     */
    private function setDatabase(Connection $database): CallCenter
    {
        $this->database = $database;
        return $this;
    }
}