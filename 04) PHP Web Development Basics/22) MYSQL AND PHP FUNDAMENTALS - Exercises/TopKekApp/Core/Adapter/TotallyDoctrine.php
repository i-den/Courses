<?php


namespace Core\Adapter;


use Models\Email;
use Models\Employee;
use Models\Phone;

/**
 * Class TotallyDoctrine
 *
 * Holds all the interaction with
 * the database and extends \PDO
 *
 * @package Core\Adapter
 */
class TotallyDoctrine extends \PDO
{
    const HOST      = '127.0.0.1';
    const DB_NAME   = 'geography';
    const USER      = 'root';
    const PASS      = 'pass123';

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
     * in the employees table
     *
     * @param   Employee $employee
     */
    public function insertEmployee(Employee $employee)
    {
        $insertEmployeeStatement = $this->prepare(
            "INSERT INTO `employees` 
                             (`first_name`, `middle_name`, `last_name`, `department`, `position`, `passport_id`, `country_code`)
                      VALUES (?, ?, ?, ?, ?, ?, ?)"
        );

        $insertEmployeeStatement->execute(array(
            $employee->getFirstName(),
            $employee->getMiddleName(),
            $employee->getLastName(),
            $employee->getDepartment(),
            $employee->getPosition(),
            $employee->getPassportId(),
            $employee->getCountryCode()
        ));
    }

    /**
     * Looks up if an Employee instance with an
     * unique first_name, middle_name, last_name AND (passport_id OR employee_id)
     * exists in the employees table
     *
     * @param string    $firstName
     * @param string    $middleName
     * @param string    $lastName
     * @param string    $id
     * @param int       $passIdOrId     1 for search by passport_id, 2 for employee_id
     * @return          bool
     */
    public function employeeExists(
        string  $firstName,
        string  $middleName,
        string  $lastName,
        string  $id,
        int     $passIdOrId
    ):  bool
    {
        $employeeExistsQuery = null;

        switch ($passIdOrId) {
            // Searching by Employee's property $passportId
            case 1:
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
                break;
            // Searching by the table's primary key employee_id
            case 2:
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
                break;
        }

        $employeeExistsQuery->execute(array(
            $firstName, $middleName, $lastName, $id
        ));

        return ($employeeExistsQuery->rowCount() > 0);
    }

    /**
     * Looks up the employee_(phone OR emails) table
     * already contains an instance with the same
     * phone_number OR email_address
     *
     * @param   string  $emAddrOrPhNum  the phone_number OR email_address
     * @param   string  $emailOrPhone   Phone or Email to point the search
     * 
     * @return bool
     */
    public function dataExists(string $emAddrOrPhNum, string $emailOrPhone): bool
    {
        $dataExistsQuery = null;

        switch ($emailOrPhone) {
            case 'Phone':
                $dataExistsQuery = $this->prepare(
                    "SELECT `phone_number`
                              FROM `employee_phones`
                              WHERE `phone_number` = ?
                              LIMIT 0, 1;"
                );
                break;
            case 'Email':
                $dataExistsQuery = $this->prepare(
                    "SELECT `email_address`
                              FROM `employee_emails`
                              WHERE `email_address` = ?
                              LIMIT 0, 1"
                );
                break;
        }

        $dataExistsQuery->execute(array(
            $emAddrOrPhNum
        ));

        return ($dataExistsQuery->rowCount() > 0);
    }

    /**
     * Inserts the provided parameters for
     * Email Address or Phone Number
     * in the corresponding table
     *
     * @param string $employeeId
     * @param string $emailAddOrPhoneNum
     * @param string $emailOrPhoneType
     * @param string $emailOrPhone
     */
    public function insertEmployeeData(
        string $employeeId,
        string $emailAddOrPhoneNum,
        string $emailOrPhoneType,
        string $emailOrPhone
    )
    {
        $insertDataQuery = null;

        switch ($emailOrPhone) {
            // Email Insert Query
            case 'Email':
                $insertDataQuery = $this->prepare(
                    "INSERT INTO `employee_emails`
                                    (`employee_id`, `email_address`, `email_type`)
                              VALUES (?, ?, ?)"
                );
                break;
            // Phone Insert Query
            case 'Phone':
                $insertDataQuery = $this->prepare(
                    "INSERT INTO `employee_phones`
                                    (`employee_id`, `phone_number`, `phone_type`)
                              VALUES (?, ?, ?)"
                );
                break;
        }

        $insertDataQuery->execute(array(
            $employeeId, $emailAddOrPhoneNum, $emailOrPhoneType
        ));
    }

    /**
     * Searches the database for Employees
     * matching exactly by their name properties
     * or by WildCard for any of the same properties
     *
     * @param   string          $firstName
     * @param   int             $fullOrWildCard
     * @param   string|null     $lastName
     * @param   string|null     $middleName
     * @return  array
     */
    public function findEmployeesByName(
        string  $firstName,
        int     $fullOrWildCard,
        string  $lastName       = null,
        string  $middleName     = null
    )
    {
        // employee_id[] to return
        $employeeIds        = array();

        $fetchEmployeeIds   = null;
        $options            = null;

        switch ($fullOrWildCard) {
            // Search by full names match
            case 1:
                if (isset($middleName)) {
                    // Searches by all three names - first_name, middle_name, last_name
                    $fetchEmployeeIds = $this->prepare(
                        "SELECT `employee_id`
                                 FROM `employees`
                                 WHERE `first_name` = ?
                                 AND `middle_name` = ?
                                 AND `last_name` = ?"
                    );

                    $options = array($firstName, $middleName, $lastName);

                } else {
                    // Searches only by first_name, last_name
                    $fetchEmployeeIds = $this->prepare(
                        "SELECT `employee_id`
                                 FROM `employees`
                                 WHERE `first_name` = ?
                                 AND `last_name` = ?"
                    );

                    $options = array($firstName, $lastName);

                }

                // Fill the employee_id[]
                if ($fetchEmployeeIds->execute($options)) {
                    while ($row = $fetchEmployeeIds->fetch(\PDO::FETCH_ASSOC)) {
                        $employeeIds[] = $row['employee_id'];
                    }
                }
                break;

            // Searches by a WildCard matching ANY of the three names - first_name, middle_name, last_name
            case 2:
                $fetchEmployeeIds = $this->prepare(
                    "SELECT `employee_id`
                             FROM employees
                             WHERE `first_name` LIKE :input
                             OR `middle_name` LIKE :input
                             OR `last_name` LIKE :input"
                );

                $wildCard = $firstName . '%';
                $fetchEmployeeIds->bindParam('input', $wildCard);

                if ($fetchEmployeeIds->execute()) {
                    while ($row = $fetchEmployeeIds->fetch(\PDO::FETCH_ASSOC)) {
                        $employeeIds[] = $row['employee_id'];
                    }
                }

                break;
        }

        return $employeeIds;
    }

    /**
     * Searches for an Employee from the database
     * by it's employee_id and returns an instance
     *
     * @param   int         $id
     * @return  Employee
     */
    public function fetchEmployeeById(int $id): Employee
    {
        $employee = null;

        $fetchEmployeeQuery = $this->prepare(
            "SELECT 
                        `first_name`, `middle_name`, `last_name`, `department`, `position`, `passport_id`, `country_code`
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
                $employeeInfo['passport_id'],
                $employeeInfo['country_code']
            );
        }

        // Search for the Employee's Email Addresses in the database
        $employeeEmails = $this->fetchEmailsByEmpId($id);

        if (!empty($employeeEmails)) {
            foreach ($employeeEmails as $employeeEmail) {
                $employee->addEmail($employeeEmail);
            }
        }

        // Search for the Employee's Phone Numbers in the database
        $employeePhones = $this->fetchPhonesByEmpId($id);

        if (!empty($employeePhones)) {
            foreach ($employeePhones as $employeePhone) {
                $employee->addPhone($employeePhone);
            }
        }

        return $employee;
    }

    /**
     * Searches for an Employee's Emails
     * by their employee_id
     *
     * @param   int       $id
     * @return  Email[]
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
     * @param   int         $id
     * @return  Phone[]
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

    /**
     * Searches for a Country in the database by
     * it's country_name OR country_code OR iso_code
     *
     * @param   string      $country
     * @return  string
     */
    public function findCountry(string $country): string
    {
        $CountryCode = null;
        $findCoutnryQuery = $this->prepare(
            "SELECT `country_code`
                      FROM `countries`
                      WHERE `country_name` = :info
                            OR `country_code` = :info
                            OR `iso_code` = :info;"
        );

        $findCoutnryQuery->bindParam('info', $country);

        if ($findCoutnryQuery->execute()) {
            $row = $findCoutnryQuery->fetch(\PDO::FETCH_ASSOC);
            $CountryCode = $row['country_code'];
        }

        return $CountryCode;
    }
}
