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
}