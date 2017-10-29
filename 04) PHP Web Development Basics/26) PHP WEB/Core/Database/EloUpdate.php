<?php


namespace Core\Database;


class EloUpdate extends Eloquent
{
    public function updateSale()
    {
        $date = $_POST['dateSold'];
        $amount = $_POST['amount'];
        $id = $_GET['id'];

        if (empty($date) || empty($amount)
        ) {
            throw new \Exception('Wrong Input!');
        } else if (!is_numeric(substr($amount, strrpos($amount, ' ')))) {
            throw new \Exception('Wrong Amount - Must Contain Number');
        }

        $updateQuery = $this->prepare(
            "UPDATE sales SET date_sold = ?, amount = ? WHERE sale_id = ?"
        );

        if ($updateQuery->execute(array($date, $amount, $id))) {
            echo 'Sale updated!';
        }
    }

    public function updateCar()
    {
        $make = $_POST['make'];
        $model = $_POST['model'];
        $year = $_POST['year'];
        $id = $_GET['id'];

        if (empty($make) || empty($model) || empty($year)) {
            throw new \Exception('Wrong Input!');
        } else if (!is_numeric($year)) {
            throw new \Exception('Faulty Entered Year!');
        }

        $updateQuery = $this->prepare(
            "UPDATE cars SET make = ?, model = ?, year = ? WHERE car_id = ?"
        );

        if ($updateQuery->execute(array($make, $model, $year, $id))) {
            echo 'Car updated!';
        }
    }

    public function updateCustomer()
    {
        $firstName = $_POST['firstName'];
        $familyName = $_POST['familyName'];
        $id = $_GET['id'];

        if (empty($firstName) || empty($familyName)) {
            throw new \Exception('Wrong Input!');
        } else if (preg_match('/[0-9]/', $firstName) || preg_match('/[0-9]/', $familyName)) {
            throw new \Exception('Faulty Entered Names!');
        }

        $ifExistsQuery = $this->prepare(
            "SELECT first_name, family_name FROM customers WHERE first_name = ? AND family_name = ?"
        );

        if ($ifExistsQuery->execute(array($firstName, $familyName))) {
            if ($ifExistsQuery->rowCount() > 0) {
                throw new \Exception('Customer with those names already exists!');
            }
            $ifExistsQuery->closeCursor();
        }

        $updateQuery = $this->prepare(
            "UPDATE customers SET first_name = ?, family_name = ? WHERE customer_id = ?"
        );

        if ($updateQuery->execute(array($firstName, $familyName, $id))) {
            echo 'Customer updated!';
        }
    }
}