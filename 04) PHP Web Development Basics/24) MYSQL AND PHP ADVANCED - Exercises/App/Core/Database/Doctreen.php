<?php


namespace Core\Database;


use Models\Car;
use Models\Customer;

/**
 * Class Doctreen
 *
 * A simple class extending \PDO, setting default
 * connection settings on Initialize and holding
 * all Database interaction
 *
 * @package Core\Database\Doctreen
 */
class Doctreen extends \PDO
{
    const DB_HOST = 'localhost';
    const DB_NAME = 'Car_Shop';
    const DB_USER = 'root';
    const DB_PASS = 'pass123';

    public function __construct()
    {
        $dsn = 'mysql:host=' . self::DB_HOST . ';dbname=' . self::DB_NAME . ';charset=utf8';
        parent::__construct(
            $dsn,
            self::DB_USER,
            self::DB_PASS,
            array(
                \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION
            )
        );
    }

    /**
     * Inserts a Sale in the Database
     * Car, Customer and Amount paid
     *
     * @param   Car         $car
     * @param   Customer    $customer
     * @param   string      $amount
     * @return  string
     */
    public function insertSale(
        Car $car,
        Customer $customer,
        string $amount
    )
    {

        $this->beginTransaction();

        $insertCarQuery = $this->prepare(
            "INSERT INTO `cars` (`make`, `model`, `year`) VALUES (?, ?, ?);"
        );

        $insertSaleQuery = $this->prepare(
            "INSERT INTO `sales` (car_id, customer_id, amount) VALUES (?, ?, ?);"
        );

        try {

            $insertCarQuery->execute(array(
                    $car->getMake(),
                    $car->getModel(),
                    $car->getYear()
                )
            );

            $carId = $this->lastInsertId();

            // Check if Customer with the same firstName and familyName doesn't exist already
            $customerId = $this->findCustomerByName(
                $customer->getFirstName(),
                $customer->getFamilyName()
            );

            // If Customer doesn't exist already - insert his details in the Database
            if ($customerId == null) {
                $insertCustomerQuery = $this->prepare(
                    "INSERT INTO `customers` (`first_name`, `family_name`) VALUES (?, ?);"
                );

                $insertCustomerQuery->execute(array(
                    $customer->getFirstName(),
                    $customer->getFamilyName()
                ));

                $customerId = $this->lastInsertId();
            }

            $insertSaleQuery->execute(array(
                $carId,
                $customerId,
                $amount
            ));
            $insertSaleQuery->closeCursor();

            $saleId = $this->lastInsertId();

            $this->commit();

            return $saleId;

        } catch (\PDOException $exception) {

            $this->rollBack();

            echo $exception->getMessage() . PHP_EOL;

        }
    }

    /**
     * Finds a customer in the Database matching it's
     * first_name and family_name
     *
     * @param   string      $firstName
     * @param   string      $familyName
     * @return  null | int
     */
    public function findCustomerByName(string $firstName, string $familyName)
    {
        $findCustomerQuery = $this->prepare(
            "CALL FIND_CUSTOMER_BY_NAMES(?, ?);"
        );

        $findCustomerQuery->execute(array(
            $firstName,
            $familyName
        ));

        if ($findCustomerQuery->rowCount() > 0) {
            $row = $findCustomerQuery->fetch(\PDO::FETCH_ASSOC);
            return $row['customer_id'];
        }

        return null;
    }

    /**
     * Finds the Date of the
     * last inserted Sale
     *
     * @param   int     $saleId
     * @return  null
     */
    public function findSaleDate(int $saleId)
    {
        $saleDate = null;

        $findDateQuery = $this->prepare(
            "CALL GET_DATE_LAST_SALE(?)"
        );

        if ($findDateQuery->execute(array($saleId))) {
            $row = $findDateQuery->fetch(\PDO::FETCH_ASSOC);
            $saleDate = $row['date_sold'];
        }

        return $saleDate;
    }

    /**
     * Lists all Sales to the Console Output
     *
     * @param  array   $saleInput   Either empty or containing two dates (Year-Month) to match between
     */
    public function showSales(array $saleInput)
    {

        // Query that will find all sales
        $showAllSalesQuery = null;
        $options = array();

        // Check if there is a specified time interval to check sales for
        switch (count($saleInput)) {

            // There isn't, list all sales
            case 1:

                $showAllSalesQuery = $this->prepare(
                    "CALL GET_SALES()"
                );

                break;

            // There are months specified, list all sales between them
            default:

            $startDate = $saleInput[1] . '-01';
            $endDate = $saleInput[2] . '-01';
            array_push($options, $startDate, $endDate);

            $showAllSalesQuery = $this->prepare(
                "CALL GET_SALES_BETWEEN_TWO_DATES(?, ?)"
            );

        }

        if ($showAllSalesQuery->execute($options)) {
            while ($row = $showAllSalesQuery->fetch(\PDO::FETCH_ASSOC)) {
                echo $row['make'] . ',' . $row['model'] . ',' . $row['date_sold'] . PHP_EOL;
                echo 'Sold to ' . $row['name'] . ' for ' . $row['amount'] . PHP_EOL;
                echo '--' . PHP_EOL;
            }
            $showAllSalesQuery->closeCursor();
        }

        echo '---------' . PHP_EOL;

        $totalQuery = $this->query("CALL GET_SALES_AMOUNT()");
        while ($amountRow = $totalQuery->fetch(\PDO::FETCH_ASSOC)) {
            echo 'Total: ' . $amountRow['sales_amount'] . PHP_EOL;
        }
    }
}
