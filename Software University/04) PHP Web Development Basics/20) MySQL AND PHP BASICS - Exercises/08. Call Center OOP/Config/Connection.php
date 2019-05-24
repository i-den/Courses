<?php


namespace Config;


class Connection extends \PDO
{
    const DB_NAME = 'geography';
    const DB_HOST = '127.0.0.1';
    const DB_USER = 'root';
    const DB_PASS = 'pass123';

    public function __construct()
    {
        $dsn = 'mysql:dbname=' . self::DB_NAME . ';host=' . self::DB_HOST . ';charset=utf8';
        try {
            parent::__construct($dsn, self::DB_USER, self::DB_PASS);
        } catch (\PDOException $e) {
            exit($e->getMessage());
        }
        $this->setErrorException();
    }

    public function setErrorSilent()
    {
        $this->setAttribute(\PDO::ATTR_ERRMODE, \PDO::ERRMODE_SILENT);
    }

    public function setErrorException()
    {
        $this->setAttribute(\PDO::ATTR_ERRMODE, \PDO::ERRMODE_EXCEPTION);
    }

}