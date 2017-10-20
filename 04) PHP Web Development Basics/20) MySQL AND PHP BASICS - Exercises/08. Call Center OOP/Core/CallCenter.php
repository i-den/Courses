<?php
/**
 * @author Denchev07
 *
 * #shtampovano
 *
 * Dobre doshli uvajaemi horica 4eteshti taz prostotiq
 * dano se zabavlqvate s moita zadachka
 * molq ne me ubivaite
 * :/
 * pozdrav de:
 * @youtube https://www.youtube.com/watch?v=FM4CQqjrZSg
 */


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
            case 4:
                try {
                    $this->handleFifthProblem($input);
                } catch (\Exception $e) {
                    echo $e->getMessage();
                }
                break;
            case 5:
                try {
                    $this->handleSexProblem($input);
                } catch (\Exception $e) {
                    echo $e->getMessage();
                }
                break;
            case 6:
                try {
                    $this->handleSeventhProblem($input);
                } catch (\Exception $e) {
                    echo $e->getMessage();
                }
                break;
            case 7:
                try {
                    $this->handleEightProblem($input);
                } catch (\Exception $e) {
                    echo $e->getMessage();
                }
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

    /*
     * @депрекейтид - Някой ден ще е без 1000 query-та..
     * -- Оправено, нали?, не и горните задачки де :/
     */
    private function handleFifthProblem($input)
    {
        $input = preg_split('/(\s|,\s)/', $input);
        $country_info = $input[1];
        $customer_name = $input[2];
        $customer_family = $input[3];
        $country_code = $this->getCountryCode($country_info);

        if ($country_code == null) {
            throw new \Exception('Country doesn\'t exist.');
        } else if ($this->customerExists($customer_name)) {
            throw new \Exception('Customer already exists');
        }

        $insertQuery = $this->getDatabase()->prepare(
            "INSERT INTO customer (customer_name, customer_family, country_code)
                      VALUES (:customer_name, :customer_family, :country_code)"
        );

        $insertQuery->bindParam('customer_name', $customer_name);
        $insertQuery->bindParam('customer_family', $customer_family);
        $insertQuery->bindParam('country_code', $country_code);

        $insertQuery->execute();
        echo 'Вие наръгахте човек със следните детайли в базичката: (демек не ми се принтат хилядата ла*на от предишните' . PHP_EOL;
        echo 'Първо име: ' . $customer_name . PHP_EOL;
        echo 'Име след първото име: ' . $customer_family . PHP_EOL;
        echo 'за повече инфо ви трябва premium версията на тая задачка' . PHP_EOL;
        echo '2 бона, колкото 1 курс в SoftUni след няколко години когато SoftUni Man, а.к.а Наков е разпрострял presence-а си до луната и курсовете се водят там' . PHP_EOL;
        echo 'Disclaimer: обичам ва, но хейт ми тролл :(' . PHP_EOL;
    }

    private function handleSexProblem($input)
    {
        $input = preg_split('/(\s|,\s)/', $input);
        $customer_name = $input[1];
        $family_name = $input[2];

        $existsQuery = $this->getDatabase()->prepare(
            "SELECT *
                      FROM customer
                      WHERE customer_name = :customer_name
                      AND customer_family = :family_name"
        );

        $existsQuery->bindParam('customer_name', $customer_name);
        $existsQuery->bindParam('family_name', $family_name);
        $existsQuery->execute();
        if ($existsQuery->rowCount() > 0) {
            $existsQuery = null;
            $deleteQuery = $this->getDatabase()->prepare(
                "DELETE
                            FROM customer
                            WHERE customer_name = :customer_name"
            );
            $deleteQuery->bindParam('customer_name', $customer_name);
            $deleteQuery->execute();
            echo 'Вие омартвихте ' . $customer_name . ' ' . $family_name . PHP_EOL;
        }
    }

    private function handleSeventhProblem($input)
    {
        preg_match('/(?<=\s)[A-Z][a-z]*(?=\?)/', $input, $matches);
        $country_name = $matches[0];

        $listQuery = $this->getDatabase()->prepare(
            "SELECT customer_name, customer_family
                       FROM customer
                       JOIN countries
                       ON customer.country_code = countries.country_code
                       WHERE countries.country_name = :country_name;"
        );
        $listQuery->bindParam('country_name', $country_name);

        if ($listQuery->execute()) {
            echo 'Customers in ' . $country_name . ':' . PHP_EOL;
            while ($row = $listQuery->fetch(\PDO::FETCH_ASSOC)) {
                echo $row['customer_name'] . ' ' . $row['customer_family'] . PHP_EOL;
            }
        }

        if ($listQuery->rowCount() == 0) {
            throw new \Exception('Епа, объркал си нещо някъде.. или няма такива животни тука..' . PHP_EOL);
        }
    }

    private function handleEightProblem($input)
    {
        preg_match('/(?<=\s)[A-Z][a-z]*(?=\?)/', $input, $matches);
        $continent_name = $matches[0];

        $listingQuery = $this->getDatabase()->prepare(
            "SELECT customer_name, customer_family
                       FROM customer
                       JOIN countries
                       ON customer.country_code = countries.country_code
                       JOIN continents
                       ON countries.continent_code = continents.continent_code
                       WHERE continents.continent_name = :continent_name;"
        );
        $listingQuery->bindParam('continent_name', $continent_name);
        if ($listingQuery->execute()) {
            echo 'Customers in ' . $continent_name . ':' . PHP_EOL;
            while ($row = $listingQuery->fetch(\PDO::FETCH_ASSOC)) {
                echo $row['customer_name'] . ' ' . $row['customer_family'] . PHP_EOL;
            }
        }

        if ($listingQuery->rowCount() == 0) {
            throw new \Exception('Бре, или няма такива или нещо си объркал' . PHP_EOL);
        }
    }

    private function loadProblems()
    {
        $this->problems = array(
            'задачка 7 - Call Center App',
            'задачка 7.1 - Add Currency and Continent',
            'задачка 7.2 - Customers in the Mountain',
            'задачка 7.3 - Special Ski Equipment',
            'задачка 9 - Add Customer Functionality',
            'задачка 10 - Delete Customer Functionality',
            'задачка 11 - Customers in Specific Country 3=)',
            'видя му се края.. 12 - Customers in Specific Continent 3==)'
        );
        $this->problemQuotes = array(
            'Цъкнете ми една рак.. [ country_name | country_code | iso_code | \'Bye\' ]: ' . PHP_EOL,
            'Подай ми [ country_code | iso_code ]' . PHP_EOL,
            'Моля един [ country_code | iso_code ]' . PHP_EOL,
            'Ти си, давай [ country_code | iso_code ]' . PHP_EOL,
            'Тука искам Customer [ country_name | country_code | iso_code ], customer_name, customer_family' . PHP_EOL,
            'Тука ша даваш кого искаш да Обиеш сас смарт, демек след кат натиснеш Enter тоя ще умре:' . PHP_EOL . ' Remove, [ customer_name ], [ customer_family ]' . PHP_EOL,
            'Аре е аре е, пиши: Customers in [ country_name ]?' . PHP_EOL,
            'За последно, тука пиши: Customers in continent [ continent_name ]?' . PHP_EOL
        );
    }

    private function customerExists(string $customer_name): bool
    {
        $existsQuery = $this->getDatabase()->prepare(
            "SELECT customer_name
                      FROM customer
                      WHERE customer_name = :customer_name"
        );
        $existsQuery->bindParam('customer_name', $customer_name);
        $existsQuery->execute();
        return ($existsQuery->rowCount() > 0);
    }

    private function getCountryCode(string $country_info)
    {
        $existsQuery = $this->getDatabase()->prepare(
            "SELECT country_code
                      FROM countries
                      WHERE country_name = :country_info
                            OR iso_code = :country_info
                            OR country_code = :country_info;"
        );
        $existsQuery->bindParam('country_info', $country_info);
        $existsQuery->execute();

        if ($existsQuery->rowCount() == 0) {
            return null;
        }

        $row = $existsQuery->fetch(\PDO::FETCH_ASSOC);
        return $row['country_code'];
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