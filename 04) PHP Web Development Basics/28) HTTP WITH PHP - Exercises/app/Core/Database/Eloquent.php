<?php


namespace Core\Database;


use Van\Entity\Cat;

abstract class Eloquent extends \PDO
{
    public function __construct()
    {
        // mysql:host={DB_HOST};dbname={DB_NAME};charset=utf8
        $dsn = 'mysql:host=' . DB_HOST . ';dbname=' . DB_NAME . ';charset=utf8';
        parent::__construct(
            $dsn,
            DB_USER,
            DB_PASS,
            array(
                \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION
            )
        );
    }

    protected function findCat(Cat $cat): int
    {
        $findCatStmt = $this->prepare(
            "SELECT `cat_id` FROM `cats` WHERE `name` = ? LIMIT 1"
        );

        if ($findCatStmt->execute($cat->getName())) {

            if ($findCatStmt->rowCount() > 0) {
                $catRow = $findCatStmt->fetch(\PDO::FETCH_ASSOC);
                return $catRow['cat_id'];
            }
        }

        return null;
    }

    protected function catExists(int $id): bool
    {
        $catExistsStmt = $this->prepare(
            "SELECT `cat_id` FROM `cats` WHERE `cat_id` = ?"
        );

        if ($catExistsStmt->execute(array($id))) {

            return $catExistsStmt->rowCount() > 0;
        }

        return false;
    }
}