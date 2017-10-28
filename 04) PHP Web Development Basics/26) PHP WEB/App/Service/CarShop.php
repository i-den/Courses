<?php


namespace App\Service;


use App\Models\Car;
use App\Models\Customer;
use Core\Database\EloDisplay;
use Core\Database\EloInsert;
use Core\Database\EloUpdate;

class CarShop
{

    public function serve()
    {
        include BASEDIR . '/App/Views/header.php';

        if (isset($_GET['list'])) {

            // Request to list Sales, Cars or Customers?
            switch ($_GET['list']) {

                // List All Sales
                case 'Sales':
                case 'sales':

                    $this->displayAllSales();

                    break;

                // List All Cars
                case 'Cars':
                case 'cars':

                    $this->displayAllCars();

                    break;

                // List All Customers:
                case 'Customers':
                case 'customers':

                    $this->displayAllCustomers();

                    break;

                // 404 Not Found Page
                default:

                    $this->displayNotFound();

                    break;

            }

        } else if (isset($_POST['submit-update'])) {

            switch ($_GET['update']) {

                case 'Sales':
                case 'sales':

                    $this->updateSale();

                    break;

            }

        } else if (isset($_GET['update'])) {

            if (isset($_GET['id'])) {

                $id = $_GET['id'];

                switch ($_GET['update']) {

                    case 'Sales':
                    case 'sales':

                        $this->displaySaleForUpdate($id);

                        break;

                    case 'Cars':
                    case 'cars':

                        break;

                    case 'Customers':
                    case 'customers':

                        break;

                }

            } else {

                // Request to update a Sale, Car or Customer
                switch ($_GET['update']) {

                    case 'Sales':
                    case 'sales':

                        $this->displaySalesForUpdate();

                        break;

                    case 'Cars':
                    case 'cars':

                        $this->displayCarsForUpdate();

                        break;

                    case 'Customers':
                    case 'customers':

                        $this->displayCustomersForUpdate();

                        break;

                }
            }


        } else {

            // Form is Filled, trying to Insert Sale Info
            if (isset($_POST['submit'])) {

                $this->insertSale();

            } else {

                // No listing Request, Displaying Form for Inserting Sale Information
                include BASEDIR . '/App/Views/main.php';

            }

        }

        include BASEDIR . '/App/Views/footer.php';
    }

    private function displayAllSales()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displaySales();
    }

    private function displayAllCars()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displayCars();
    }

    private function displayAllCustomers()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displayCustomers();
    }

    private function displayNotFound()
    {
        header('HTTP/1.1 404 Not Found');
        include BASEDIR . '/public_html/Errors/404.php';
    }

    private function insertSale()
    {
        try {

            $car = new Car(
                htmlspecialchars($_POST['make']),
                htmlspecialchars($_POST['model']),
                intval(htmlspecialchars($_POST['year']))
            );

            $customer = new Customer(
                htmlspecialchars($_POST['firstName']),
                htmlspecialchars($_POST['familyName'])
            );

        } catch (\Exception $exception) {

            $errorMessage = $exception->getMessage();

            include BASEDIR . '/App/Views/error.php';

            return;

        }

        $amount = $_POST['amount'];

        $insertQuery = new EloInsert();
        $saleId = $insertQuery->insertSale($car, $customer, $amount);
    }

    private function displaySalesForUpdate()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displaySalesForUpdate();
    }

    private function displayCarsForUpdate()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displayCarsForUpdate();
    }

    private function displayCustomersForUpdate()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displayCustomersForUpdate();
    }

    private function displaySaleForUpdate(int $id)
    {
        $dbUpdate = new EloDisplay();

        try {

            $dbUpdate->displaySaleForUpdate($id);

        } catch (\Exception $exception) {

            $errorMessage = $exception->getMessage();

            include BASEDIR . '/App/Views/error.php';

            return;

        }

    }

    private function updateSale()
    {
        $dbUpdate = new EloUpdate();

        try {

            $dbUpdate->updateSale();

        } catch (\Exception $exception) {

            $errorMessage = $exception->getMessage();

            include BASEDIR . '/App/Views/error.php';

            return;

        }

    }
}