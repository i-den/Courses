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
    }

    public function query(string $query): PreparedStatementInterface
    {
        $statement = $this->pdo->prepare(
            $query
        );

        return new PDOPreparedStatement($statement);
    }

    public function getLastError()
    {
        return $this->pdo->errorInfo();
    }

    public function getLastId(): int
    {
        return $this->pdo->lastInsertId();
    }
}