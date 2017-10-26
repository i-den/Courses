<?php


namespace Service;


use Core\Database\Doctreen;
use Models\Car;
use Models\Customer;

class CarShop
{
    /** @var  Doctreen */
    private $database;

    /**
     * CarShop constructor.
     * @param Doctreen $database
     */
    public function __construct(Doctreen $database)
    {
        $this->setDatabase($database);
    }

    public function serve()
    {
        while (true) {

            $saleInput = explode(', ', trim(fgets(STDIN)));

            if ($saleInput[0] == 'Bye') {
                break;
            }

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

            $this->getDatabase()->insertSale(
                $car,
                $customer,
                $amount
            );

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
     * @param Doctreen $database
     * @return CarShop
     */
    public function setDatabase(Doctreen $database): CarShop
    {
        $this->database = $database;
        return $this;
    }
}