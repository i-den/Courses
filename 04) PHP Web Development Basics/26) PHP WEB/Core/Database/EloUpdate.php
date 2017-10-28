<?php


namespace Core\Database;


class EloUpdate extends Eloquent
{
    public function updateSale()
    {
        $date = $_POST['dateSold'];
        $amount = $_POST['amount'];
        $id = $_GET['id'];

        if (!is_numeric(substr($amount, strrpos($amount, ' ')))) {
            throw new \Exception('Wrong Amount - Must Contain Number');
        }

        $updateQuery = $this->prepare(
            "UPDATE sales SET date_sold = ?, amount = ? WHERE sale_id = ?"
        );

        if ($updateQuery->execute(array($date, $amount, $id))) {
            echo 'Sale updated!';
        }
    }
}