<?php


namespace Service;


use Core\Database\Doctreen;
use Models\Car;
use Models\Customer;

/**
 * Class CarShop
 *
 * The main Application Class, taking CLI Input
 * and interacts with the Database
 *
 * @package Service
 */
class CarShop
{
    /** @var  Doctreen */
    private $database;

    /**
     * CarShop constructor.
     * @param  Doctreen    $database
     */
    public function __construct(Doctreen $database)
    {
        $this->setDatabase($database);
    }

    /**
     * Entry point for the Car Shop application
     */
    public function serve()
    {

        while (true) {

            $saleInput = explode(', ', trim(fgets(STDIN)));

            if ($saleInput[0] == 'Bye') {
                break;
            }

            // Either Insert Sales or List them
            switch ($saleInput[0]) {

                // Show sales
                case 'Sales':

                    $this->getDatabase()->showSales($saleInput);

                    break;

                // Insert Sales - Car, Customer and Amount
                default:

                    $car = new Car(
                        $saleInput[0],
                        $saleInput[1],
                        intval($saleInput[2])
                    );

                    $customer = new Customer(
                        $saleInput[3],
                        $saleInput[4]
                    );

                    $amount = $saleInput[5];

                    $saleId = $this->getDatabase()->insertSale(
                        $car,
                        $customer,
                        $amount
                    );

                    $saleDate = $this->getDatabase()->findSaleDate($saleId);
                    echo 'New sale entered ' . $saleDate . PHP_EOL;

                    break;

            }
        }
    }

    /**
     * @return Doctreen
     */
    public function getDatabase(): Doctreen
    {
        return $this->database;
    }

    /**
     * @param   Doctreen    $database
     * @return  CarShop
     */
    public function setDatabase(Doctreen $database): CarShop
    {
        $this->database = $database;
        return $this;
    }
}