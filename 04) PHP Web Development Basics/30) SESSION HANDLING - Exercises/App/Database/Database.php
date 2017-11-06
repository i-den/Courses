<?php


namespace Database;

/**
 * Class Database
 *
 * Simple PDO Wrapper
 * encapsulates and divides the PDO logic
 * into three different classes
 *
 * @package Database
 */
class Database implements DatabaseInterface
{
    /**
     * @var \PDO
     */
    private $database;

    public function __construct(\PDO $database)
    {
        $this->database = $database;
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
