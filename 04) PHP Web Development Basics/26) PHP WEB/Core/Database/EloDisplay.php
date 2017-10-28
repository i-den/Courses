<?php


namespace Core\Database;


class EloDisplay extends Eloquent
{
    public function displaySales()
    {
        $displayQuery = $this->prepare('CALL GET_SALES()');

        if ($displayQuery->execute()) {
            $allSales = $displayQuery->fetchAll(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/sales.php';
        }
    }

    public function displaySalesForUpdate()
    {
        $displayQuery = $this->prepare('CALL GET_SALES_FOR_UPDATE');

        if ($displayQuery->execute()) {
            $salesForUpdate = $displayQuery->fetchAll(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/sales-update.php';
        }
    }

    public function displayCars()
    {
        $displayQuery = $this->prepare('CALL GET_CARS()');

        if ($displayQuery->execute()) {
            $allCars = $displayQuery->fetchAll(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/cars.php';
        }
    }

    public function displayCarsForUpdate()
    {
        $displayQuery = $this->prepare('CALL GET_CARS_FOR_UPDATE()');

        if ($displayQuery->execute()) {
            $carsForUpdate = $displayQuery->fetchAll(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/cars-update.php';
        }
    }

    public function displayCustomers()
    {
        $displayQuery = $this->prepare('CALL GET_CUSTOMERS()');

        if ($displayQuery->execute()) {
            $allCustomers = $displayQuery->fetchAll(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/customers.php';
        }
    }

    public function displayCustomersForUpdate()
    {
        $displayQuery = $this->prepare('CALL GET_CUSTOMERS_FOR_UPDATE()');

        if ($displayQuery->execute()) {
            $customersForUpdate = $displayQuery->fetchAll(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/customers-update.php';
        }
    }

    public function displaySaleForUpdate(int $id)
    {
        $displaySingleSaleQuery = $this->prepare(
            "SELECT `date_sold`, `amount` FROM `sales` WHERE `sales`.`sale_id` = ?;");

        if ($displaySingleSaleQuery->execute(array($id))) {

            if (!$displaySingleSaleQuery->rowCount() > 0) {
                throw new \Exception('No sale found with ID = ' . $id);
            }

            $saleForUpdate = $displaySingleSaleQuery->fetch(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/sale-update.php';
        }
    }
}