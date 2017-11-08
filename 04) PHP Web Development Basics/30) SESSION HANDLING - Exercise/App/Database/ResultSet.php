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

    public function fetch(string $className): \Generator
    {
        while ($object = $this->preparedStatement->fetchObject($className)) {
            yield $object;
        }
    }
}
