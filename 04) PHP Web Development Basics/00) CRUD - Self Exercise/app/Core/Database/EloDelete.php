<?php


namespace Core\Database;

use Van\Entity\Cat;

class EloDelete extends Eloquent
{
    public function deleteCat(Cat $cat)
    {
        $catId = $this->findCat($cat);

        if ($catId == null) {
            throw new \Exception('Cat not found!');
        }

        $deleteCatStmt = $this->prepare(
            "DELETE FROM `cats` WHERE `cat_id` = ?"
        );

        $deleteCatStmt->execute(array($catId));
    }
}