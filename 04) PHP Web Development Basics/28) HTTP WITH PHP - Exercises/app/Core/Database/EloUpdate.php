<?php


namespace Core\Database;


use Van\Entity\Cat;

class EloUpdate extends Eloquent
{
    public function updateCat(int $id, Cat $cat)
    {
        if (!$this->catExists($id)) {
            throw new \Exception('Cat not found!');
        }

        $updateCatStmt = $this->prepare(
            "UPDATE `cats` SET `name` = ?, `age` = ? WHERE `cat_id` = ?"
        );

        $updateCatStmt->execute(array($cat->getName(), $cat->getAge(), $id));
    }
}