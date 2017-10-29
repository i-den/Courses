<?php


namespace Core\Database;


class EloDisplay extends Eloquent
{
    public function displaySales()
    {
        $displayQuery = $this->prepare('CALL GET_SALES()');

        if ($displayQuery->execute()) {
            $allSales = $displayQuery->fetchAll(\PDO::FETCH_ASSOC);
            $displayQuery->closeCursor();

            $totalAmountQuery = $this->prepare('CALL GET_SALES_AMOUNT()');

            if ($totalAmountQuery->execute()) {
                $totalAmount = $totalAmountQuery->fetch(\PDO::FETCH_ASSOC);

                include BASEDIR . '/App/Views/sales.php';
            }
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
            "SELECT `date_sold`, `amount` FROM `sales` WHERE `sales`.`sale_id` = ?;"
        );

        if ($displaySingleSaleQuery->execute(array($id))) {

            if (!$displaySingleSaleQuery->rowCount() > 0) {
                throw new \Exception('No sale found with ID = ' . $id);
            }

            $saleForUpdate = $displaySingleSaleQuery->fetch(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/sale-update.php';
        }
    }

    public function displayCarForUpdate(int $id)
    {
        $displaySingleCarQuery = $this->prepare(
            "SELECT `make`, `model`, `year` FROM `cars` WHERE `car_id` = ?;"
        );

        if ($displaySingleCarQuery->execute(array($id))) {

            if (!$displaySingleCarQuery->rowCount() > 0) {
                throw new \Exception('No car found with ID = ' . $id);
            }

            $carForUpdate = $displaySingleCarQuery->fetch(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/car-update.php';
        }
    }

    public function displayCustomerForUpdate(int $id)
    {
        $displaySingleCustomerQuery = $this->prepare(
            "SELECT `first_name`, `family_name` FROM `customers` WHERE `customer_id` = ?;"
        );

        if ($displaySingleCustomerQuery->execute(array($id))) {

            if (!$displaySingleCustomerQuery->rowCount() > 0) {
                throw new \Exception('No customer found with ID = ' . $id);
            }

            $customerForUpdate = $displaySingleCustomerQuery->fetch(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/customer-update.php';
        }
    }

    public function displaySearch()
    {
        $make = trim($_GET['search']);

        $searchByMakeQuery = $this->prepare(
            "SELECT  `make`, `model`, `year`, `car_id`, `first_name`, `family_name`, `customer_id`FROM sales JOIN customers USING(customer_id) JOIN cars USING(car_id) WHERE `make` = ?;"
        );

        if ($searchByMakeQuery->execute(array($make))) {

            if (!$searchByMakeQuery->rowCount() > 0) {
                throw new \Exception('No ' . $make . ' sales found!');
            }

            $allCars = $searchByMakeQuery->fetchAll(\PDO::FETCH_ASSOC);
            include BASEDIR . '/App/Views/list-by-search.php';
        }
    }
}