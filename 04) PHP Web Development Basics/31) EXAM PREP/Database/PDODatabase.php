<?php


namespace Database;


class PDODatabase implements DatabaseInterface
{
    /**
     * @var \PDO
     */
    private $pdo;

    public function __construct(\PDO $pdo)
    {
        $this->pdo = $pdo;
        $this->pdo->setAttribute(\PDO::ATTR_ERRMODE, \PDO::ERRMODE_EXCEPTION);
    }

    public function query(string $query): StatementInterface
    {
        return new PDOPreparedStatement($this->pdo->prepare($query));
    }

    public function getLastError(): array
    {
        return $this->pdo->errorInfo();
    }
}