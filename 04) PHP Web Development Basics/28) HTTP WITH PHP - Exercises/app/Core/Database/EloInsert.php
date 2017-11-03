<?php


namespace Core\Database;


use Van\Entity\Cat;

class EloInsert extends Eloquent
{
    public function insertCat(Cat $cat)
    {
        $insertCatStmt = $this->prepare(
            "INSERT INTO `cats` (`name`, `age`) VALUES(?, ?)"
        );

        $this->beginTransaction();

        try {

            $insertCatStmt->execute(array(
                $cat->getName(),
                $cat->getAge()
            ));

            $this->commit();

        } catch (\PDOException $exception) {

            $this->rollBack();

            throw new \PDOException('Cat most likely exists already!' . '<br/>' . $exception->getMessage());

        }
    }
}