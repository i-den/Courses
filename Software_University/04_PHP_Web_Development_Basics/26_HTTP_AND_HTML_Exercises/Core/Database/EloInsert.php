<?php


namespace Core\Database;


use App\Models\Car;
use App\Models\Customer;

class EloInsert extends Eloquent
{
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
            ));

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

            $errorMessage = $exception->getMessage();

            include BASEDIR . '/App/Views/error.php';

        }
    }
}