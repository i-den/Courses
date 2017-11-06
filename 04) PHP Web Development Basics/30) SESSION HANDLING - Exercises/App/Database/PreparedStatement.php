<?php


namespace Database;

/**
 * Class PreparedStatement
 *
 * PDOStatement wrapper that only executes queries
 * and returns another class that will take care
 * of fetching form the Database
 *
 * @package Database
 */
class PreparedStatement implements PreparedStatementInterface
{
    /**
     * @var \PDOStatement
     */
    private $preparedStatement;

    public function __construct(\PDOStatement $preparedStatement)
    {
        $this->preparedStatement = $preparedStatement;
    }

    public function execute(array $params = []): ResultSetInterface
    {
        $this->preparedStatement->execute($params);

        return new ResultSet($this->preparedStatement);
    }
}
