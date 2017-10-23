<?php


namespace Core\Adapter;


use Models\Email;
use Models\Employee;
use Models\Phone;

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
     * @param string $id
     * @param int $passIdOrId
     * @return bool
     */
    public function employeeExists(
        string $firstName,
        string $middleName,
        string $lastName,
        string $id,
        int $passIdOrId
    ): bool
    {
        $employeeExistsQuery = null;

        if ($passIdOrId == 1) {
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
        } else {
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
                            AND `employee_id` = ?
                      LIMIT 0, 1;"
            );
        }


        $employeeExistsQuery->execute(array(
            $firstName, $middleName, $lastName, $id
        ));

        return ($employeeExistsQuery->rowCount() > 0);
    }

    /**
     * Checks if the email table
     * contains an email
     * with the same address
     *
     * @param string $emailOrPhone
     * @param  string $option
     * @return bool
     */
    public function dataExists(string $emailOrPhone, string $option): bool
    {
        $dataExistsQuery = null;

        if ($option == 'Email') {
            $dataExistsQuery = $this->prepare(
                "SELECT `email_address`
                          FROM `employee_emails`
                          WHERE `email_address` = ?
                          LIMIT 0, 1"
            );
        } else {
            $dataExistsQuery = $this->prepare(
                "SELECT `phone_number`
                          FROM `employee_phones`
                          WHERE `phone_number` = ?
                          LIMIT 0, 1;"
            );
        }


        $dataExistsQuery->execute(array(
            $emailOrPhone
        ));

        return ($dataExistsQuery->rowCount() > 0);
    }

    public function insertEmployeeData(
        string $employeeId,
        string $emailAddOrPhoneNum,
        string $dataType,
        string $option
    )
    {
        $insertDataQuery = null;
        if ($option == 'Email') {
            $insertDataQuery = $this->prepare(
                "INSERT INTO `employee_emails`
                            (`employee_id`, `email_address`, `email_type`)
                          VALUES (?, ?, ?)"
            );
        } else {
            $insertDataQuery = $this->prepare(
                "INSERT INTO `employee_phones`
                            (`employee_id`, `phone_number`, `phone_type`)
                          VALUES (?, ?, ?)"
            );
        }

        $insertDataQuery->execute(array(
            $employeeId, $emailAddOrPhoneNum, $dataType
        ));
    }

    public function findEmployeesByName($firstName, $lastName, $middleName = null)
    {
        $employeeIds = array();
        $fetchEmployeeIds = null;
        $options = null;
        if (isset($middleName)) {
            $fetchEmployeeIds = $this->prepare(
                "SELECT `employee_id`
                      FROM `employees`
                      WHERE `first_name` = ?
                      AND `middle_name` = ?
                      AND `last_name` = ?"
            );
            $options = array($firstName, $middleName, $lastName);
        } else {
            $fetchEmployeeIds = $this->prepare(
                "SELECT `employee_id`
                      FROM `employees`
                      WHERE `first_name` = ?
                      AND `last_name` = ?"
            );
            $options = array($firstName, $lastName);
        }

        if ($fetchEmployeeIds->execute($options)) {
            while ($row = $fetchEmployeeIds->fetch(\PDO::FETCH_ASSOC)) {
                $employeeIds[] = $row['employee_id'];
            }
        }

        return $employeeIds;
    }

    public function fetchEmployeeById(int $id): Employee
    {
        $employee = null;
        $fetchEmployeeQuery = $this->prepare(
            "SELECT 
                        `first_name`, `middle_name`, `last_name`, `department`, `position`, `passport_id`
                      FROM `employees`
                      WHERE `employee_id` = ?"
        );

        if ($fetchEmployeeQuery->execute(array($id))) {
            $employeeInfo = $fetchEmployeeQuery->fetch(\PDO::FETCH_ASSOC);
            $employee = new Employee(
                $employeeInfo['first_name'],
                $employeeInfo['middle_name'],
                $employeeInfo['last_name'],
                $employeeInfo['department'],
                $employeeInfo['position'],
                $employeeInfo['passport_id']
            );
        }

        $employeeEmails = $this->fetchEmailsByEmpId($id);

        if (!empty($employeeEmails)) {
            foreach ($employeeEmails as $employeeEmail) {
                $employee->addEmail($employeeEmail);
            }
        }

        $employeePhones = $this->fetchPhonesByEmpId($id);

        if (!empty($employeePhones)) {
            foreach ($employeePhones as $employeePhone) {
                $employee->addPhone($employeePhone);
            }
        }

        return $employee;
    }

    /**
     * @param int $id
     * @return Email[]
     */
    public function fetchEmailsByEmpId(int $id): array
    {
        $emails = array();

        $fetchEmailsQuery = $this->prepare(
            "SELECT
                       `email_address`, `email_type`
                     FROM `employee_emails`
                     WHERE `employee_id` = ?;"
        );

        if ($fetchEmailsQuery->execute(array($id))) {
            while ($row = $fetchEmailsQuery->fetch(\PDO::FETCH_ASSOC)) {
                $emails[] = new Email(
                    $row['email_address'],
                    $row['email_type']
                );
            }
        }

        return $emails;
    }

    /**
     * @param int $id
     * @return Phone[]
     */
    public function fetchPhonesByEmpId(int $id): array
    {
        $phones = array();

        $fetchPhonesQuery = $this->prepare(
            "SELECT `phone_number`, `phone_type`
                     FROM `employee_phones`
                     WHERE `employee_id` = ?;"
        );

        if ($fetchPhonesQuery->execute(array($id))) {
            while ($row = $fetchPhonesQuery->fetch(\PDO::FETCH_ASSOC)) {
                $phones[] = new Phone(
                    $row['phone_number'],
                    $row['phone_type']
                );
            }
        }

        return $phones;
    }
}
