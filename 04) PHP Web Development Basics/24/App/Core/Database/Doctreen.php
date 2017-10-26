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
     * Inserts a Sale into the Database:
     * Car, Customer and their related table Sales
     *
     * @param   Car         $car
     * @param   Customer    $customer
     * @param   string      $amount
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

        $insertCustomerQuery = $this->prepare(
            "INSERT INTO `customers` (`first_name`, `family_name`) VALUES (?, ?);"
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

            $insertCustomerQuery->execute(array(
               $customer->getFirstName(),
                $customer->getFamilyName()
            ));

            $customerId = $this->lastInsertId();

            $insertSaleQuery->execute(array(
               $carId,
                $customerId,
                $amount
            ));

            $saleId = $this->lastInsertId();

            $getDateQuery = $this->prepare(
                "SELECT `date_sold` FROM `sales`WHERE `sale_id` = ?"
            );

            $this->commit();

            // Output the exact date that the Sale was Inserted in the Database
            if ($getDateQuery->execute(array($saleId))) {
                $dateRow = $getDateQuery->fetch(\PDO::FETCH_ASSOC);
                echo 'New sale entered ' . $dateRow['date_sold'] . PHP_EOL;
            }

        } catch (\PDOException $exception) {

            $this->rollBack();

            echo $exception->getMessage() . PHP_EOL;

        }
    }
}
