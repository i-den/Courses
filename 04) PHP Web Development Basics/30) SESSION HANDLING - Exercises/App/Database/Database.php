<?php


namespace Database;


class Database implements DatabaseInterface
{
    /**
     * @var \PDO
     */
    private $database;

    public function __construct(\PDO $database)
    {
        $this->database = $database;
        $this->database->setAttribute(\PDO::ATTR_ERRMODE, \PDO::ERRMODE_EXCEPTION);
    }

    public function prepare(string $queryString): PreparedStatementInterface
    {
        return new PreparedStatement($this->database->prepare($queryString));
    }

    public function getLastError(): array
    {
       return $this->database->errorInfo();
    }

    public function getLastInsertId(): string
    {
        return $this->database->lastInsertId();
    }
}
