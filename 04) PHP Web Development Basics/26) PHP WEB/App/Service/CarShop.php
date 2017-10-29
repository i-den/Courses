<?php


namespace App\Service;


use App\Models\Car;
use App\Models\Customer;
use Core\Database\EloDisplay;
use Core\Database\EloInsert;
use Core\Database\EloUpdate;

/**
 * Class CarShop
 *
 * Friendly reminder from the Author:
 * - This is my first time ever doing CRUD without any help
 * and the code is sh*t as f*ck, I do acknowledge this
 *
 * Please, do not refer to this code as nothing but
 * kinda working CRUD, hopefully I'll improve one day ;)
 *
 * @package App\Service
 */
class CarShop
{

    /**
     * Entry point for the application
     * this is mega leshta
     */
    public function serve()
    {
        // Load Headers
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

            // Request to Update a Sale, Car or Customer
            switch ($_GET['update']) {

                // Updating Sale
                case 'Sales':
                case 'sales':

                    $this->updateSale();

                    break;

                // Updating Car
                case 'Cars':
                case 'cars':

                    $this->updateCar();

                    break;

                // Updating Customer
                case 'Customers':
                case 'customers':

                    $this->updateCustomer();

                    break;

            }

            // Request to Update a Car, Sale or Customer
        } else if (isset($_GET['update'])) {

            // Request sent to update a specific Car, Sale or Customer
            if (isset($_GET['id'])) {

                $id = $_GET['id'];

                switch ($_GET['update']) {

                    case 'Sales':
                    case 'sales':

                        $this->displaySaleForUpdate($id);

                        break;

                    case 'Cars':
                    case 'cars':

                        $this->displayCarForUpdate($id);

                        break;

                    case 'Customers':
                    case 'customers':

                        $this->displayCustomerForUpdate($id);

                        break;

                }

            } else {

                // Request sent to list all Cars, Sales and Customers available for Update
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

            // Search by Make request
        } else if (isset($_GET['search'])) {

            $this->displaySearch();

            // Main page
        } else {

            // Form is Filled, trying to Insert Sale Info
            if (isset($_POST['submit'])) {

                $this->insertSale();

            } else {

                // No listing Request, Displaying Form for Inserting Sale Information
                include BASEDIR . '/App/Views/main.php';

            }

        }

        // Load footer
        include BASEDIR . '/App/Views/footer.php';
    }

    /**
     * Includes the View with all Sales listed from the Database
     */
    private function displayAllSales()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displaySales();
    }

    /**
     * Includes the View with all Cars listed from the Database
     */
    private function displayAllCars()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displayCars();
    }

    /**
     * Includes the View with all Customers listed from the Database
     */
    private function displayAllCustomers()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displayCustomers();
    }

    /**
     * 404 View
     */
    private function displayNotFound()
    {
        header('HTTP/1.1 404 Not Found');
        include BASEDIR . '/public_html/Errors/404.php';
    }

    /**
     * Main Method for Inserting a Sale into the Database
     * - Customer, Car, Amount
     */
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

    /**
     * Lists all Sales with their information that can be updated
     */
    private function displaySalesForUpdate()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displaySalesForUpdate();
    }

    /**
     * Lists all Cars with their information that can be updated
     */
    private function displayCarsForUpdate()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displayCarsForUpdate();
    }

    /**
     * Lists all Customers with their information that can be updated
     */
    private function displayCustomersForUpdate()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displayCustomersForUpdate();
    }

    /**
     * Displays the requested Sale's details that will be updated
     *
     * @param int $id
     */
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

    /**
     * Displays the requested Car's details that will be updated
     *
     * @param int $id
     */
    private function displayCarForUpdate(int $id)
    {
        $dbUpdate = new EloDisplay();

        try {

            $dbUpdate->displayCarForUpdate($id);

        } catch (\Exception $exception) {

            $errorMessage = $exception->getMessage();

            include BASEDIR . '/App/Views/error.php';

            return;

        }
    }

    /**
     * Displays the requested Customer's details that will be updated
     *
     * @param int $id
     */
    private function displayCustomerForUpdate(int $id)
    {
        $dbUpdate = new EloDisplay();

        try {

            $dbUpdate->displayCustomerForUpdate($id);

        } catch (\Exception $exception) {

            $errorMessage = $exception->getMessage();

            include BASEDIR . '/App/Views/error.php';

            return;

        }
    }

    /**
     * Tries to update the Sale with the New Information
     */
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

    /**
     * Tries to update the Car with the New Information
     */
    private function updateCar()
    {
        $dbUpdate = new EloUpdate();

        try {

            $dbUpdate->updateCar();

        } catch (\Exception $exception) {

            $errorMessage = $exception->getMessage();

            include BASEDIR . '/App/Views/error.php';

            return;

        }
    }

    /**
     * Tries to update the Customer with the New Information
     */
    private function updateCustomer()
    {
        $dbUpdate = new EloUpdate();

        try {

            $dbUpdate->updateCustomer();

        } catch (\Exception $exception) {

            $errorMessage = $exception->getMessage();

            include BASEDIR . '/App/Views/error.php';

            return;

        }
    }

    private function displaySearch()
    {
        $dbDisplay = new EloDisplay();

        try {

            $dbDisplay->displaySearch();

        } catch (\Exception $exception) {

            $errorMessage = $exception->getMessage();

            include BASEDIR . '/App/Views/error.php';

            return;
        }
    }
}