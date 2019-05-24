<?php


namespace Database;


class ResultSet implements ResultSetInterface
{
    /**
     * @var \PDOStatement
     */
    private $preparedStatement;

    public function __construct(\PDOStatement $preparedStatement)
    {
        $this->preparedStatement = $preparedStatement;
    }

    public function fetchObject(string $className): \Generator
    {
        while ($object = $this->preparedStatement->fetchObject($className)) {
            yield $object;
        }
    }

    public function fetchRow(string $key)
    {
        $row =  $this->preparedStatement->fetch(\PDO::FETCH_ASSOC);
        $this->preparedStatement->closeCursor();
        return $row[$key];
    }
}
