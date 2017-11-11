<?php


namespace Database;


class PDOResultSet implements ResultSetInterface
{
    /**
     * @var \PDOStatement
     */
    private $pdoPreparedStatement;

    public function __construct(\PDOStatement $pdoPreparedStatement)
    {
        $this->pdoPreparedStatement = $pdoPreparedStatement;
    }

    public function fetch(string $className = null): \Generator
    {
        if (null === $className) {
            while ($row = $this->pdoPreparedStatement->fetch(\PDO::FETCH_ASSOC)) {
                yield $row;
            }
        } else {
            while ($row = $this->pdoPreparedStatement->fetchObject($className)) {
                yield $row;
            }
        }
    }

    public function fetchColumn(int $colNum = 0)
    {
        return $this->pdoPreparedStatement->fetchColumn($colNum);
    }
}