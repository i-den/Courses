<?php


namespace Database;

/**
 * Class ResultSet
 *
 * Class taking care of just fetching (yielding)
 * objects from the database
 *
 * @package Database
 */
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
        while ($row = $this->preparedStatement->fetchObject($className)) {

            yield $row;
        }
    }
}
