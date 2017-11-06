<?php


namespace Database;


class PDOPreparedStatement implements PreparedStatementInterface
{
    /**
     * @var \PDOStatement
     */
    private $pdoStatement;

    public function __construct(\PDOStatement $pdoStatement)
    {
        $this->pdoStatement = $pdoStatement;
    }

    public function execute(array $params = array()): ResultSetInterface
    {
        $this->pdoStatement->execute(
            $params
        );

        return new ResultSet($this->pdoStatement);
    }
}