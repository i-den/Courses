<?php


namespace App\Service;


use Core\Database\EloDisplay;

class CarShop
{

    public function serve()
    {
        include BASEDIR . '/App/Views/header.php';

        // Request to list Sales, Cars or Customers?
        if (isset($_GET['list'])) {

            switch ($_GET['list']) {

                // Sales entered
                case 'Sales':
                case 'sales':

                    $this->displayAllSales();

                    break;

                case '':

                    break;

            }

        } else {

            include BASEDIR . '/App/Views/main.php';

            if (isset($_GET['submit'])) {

            }

        }

        include BASEDIR . '/App/Views/footer.php';
    }

    private function displayAllSales()
    {
        $dbDisplay = new EloDisplay();

        $dbDisplay->displaySales();
    }
}