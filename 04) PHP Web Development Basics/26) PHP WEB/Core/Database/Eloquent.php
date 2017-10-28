<?php


namespace Core\Database;


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
}