<?php


namespace Core\Adapter;


use Models\Employee;

class TotallyDoctrine extends \PDO
{
    const HOST = '127.0.0.1';
    const DB_NAME = 'geography';
    const USER = 'root';
    const PASS = 'pass123';

    /**
     * TotallyDoctrine constructor.
     */
    public function __construct()
    {
        $dsn = 'mysql:host=' . self::HOST . ';dbname=' . self::DB_NAME . ';charset=utf8';
        parent::__construct(
            $dsn,
            self::USER,
            self::PASS,
            array(
                \PDO::ATTR_ERRMODE, \PDO::ERRMODE_EXCEPTION
            )
        );
    }

    /**
     * Inserts an Employee instance
     * in the database
     *
     * @param Employee $employee
     */
    public function insertEmployee(Employee $employee)
    {
        $insertEmployeeStatement = $this->prepare(
            "INSERT INTO `employees` 
                             (`first_name`, `middle_name`, `last_name`, `department`, `position`, `passport_id`)
                      VALUES (?, ?, ?, ?, ?, ?)"
        );

        $insertEmployeeStatement->execute(array(
            $employee->getFirstName(),
            $employee->getMiddleName(),
            $employee->getLastName(),
            $employee->getDepartment(),
            $employee->getPosition(),
            $employee->getPassportId()
        ));
    }

    /**
     * Checks if the Database already
     * has an Employee entry with
     * the given parameters
     *
     * @param string $firstName
     * @param string $middleName
     * @param string $lastName
     * @param string $passId
     * @return bool
     */
    public function employeeExists(
        string $firstName,
        string $middleName,
        string $lastName,
        string $passId): bool
    {
        $employeeExistsQuery = $this->prepare(
            "SELECT
                        `first_name`,
                        `middle_name`,
                        `last_name`,
                        `passport_id`
                      FROM `employees`
                      WHERE `first_name` = ?
                            AND `middle_name` = ?
                            AND `last_name` = ?
                            AND `passport_id` = ?
                      LIMIT 0, 1;"
        );

        $employeeExistsQuery->execute(array(
            $firstName, $middleName, $lastName, $passId
        ));

        return ($employeeExistsQuery->rowCount() > 0);
    }
}
