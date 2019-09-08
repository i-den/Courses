<?php


namespace Database;


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
