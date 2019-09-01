<?php


namespace Core\Database;


use Van\Entity\Cat;

class EloFind extends Eloquent
{
    public function getAllCats(): array
    {
        $listCatsStmt = $this->prepare(
            "SELECT `name`, `age`, `cat_id` FROM `cats`"
        );

        $listCatsStmt->execute();

        return $listCatsStmt->fetchAll();
    }

    public function getCatById(int $id): Cat
    {
        $getCatByIdStmt = $this->prepare(
            "SELECT `cat_id`, `name`, `age` FROM `cats` WHERE `cat_id` = ?"
        );

        $getCatByIdStmt->execute(array($id));

        if ($getCatByIdStmt->rowCount() == 0) {
            throw new \Exception('No such cat found');
        }

        $catRow = $getCatByIdStmt->fetch(\PDO::FETCH_ASSOC);

        return new Cat($catRow['name'], $catRow['age']);
    }
}