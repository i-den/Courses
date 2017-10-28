<?php


namespace Core\Database;


abstract class Eloquent extends \PDO
{
    public function __construct()
    {
        // mysql:host={DB_HOST};dbname={DB_NAME};charset=utf8
        $dsn = 'mysql:host=' . DB_HOST . ';dbname=' . DB_NAME . ';charset=utf8';

        parent::__construct(
            $dsn,
            DB_USER,
            DB_PASS,
            array(
                \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION
            )
        );
    }

    /**
     * Finds a customer in the Database matching it's
     * first_name and family_name
     *
     * @param   string      $firstName
     * @param   string      $familyName
     * @return  null | int
     */
    public function findCustomerByName(string $firstName, string $familyName)
    {
        $findCustomerQuery = $this->prepare(
            "CALL FIND_CUSTOMER_BY_NAMES(?, ?);"
        );

        $findCustomerQuery->execute(array(
            $firstName,
            $familyName
        ));

        if ($findCustomerQuery->rowCount() > 0) {
            $row = $findCustomerQuery->fetch(\PDO::FETCH_ASSOC);
            return $row['customer_id'];
        }

        return null;
    }

}