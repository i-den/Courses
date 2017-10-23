<?php


namespace Core\Service\Commands;


use Core\Adapter\TotallyDoctrine;

/**
 * Class ThirdCommand
 *
 * Responsible for Inserting Employee
 * Emails or Phones in the Database
 *
 * @package Core\Service\Commands
 */
class ThirdCommand extends Command
{

    public function __construct(TotallyDoctrine $database)
    {
        parent::__construct($database);
    }

    /**
     * Checks if there's a query for a single Employee
     * or for multiple ones with the same name
     *
     * @param   array|null  $options    Phone or Email
     */
    public function execute(array $options = null)
    {
        $emailOrPhone   = $options[0];
        $split          = strtolower($emailOrPhone) . 's';
        $input          = explode($split . ', ', trim(fgets(STDIN)));

        // F*ck you preg_split PREG_SPLIT_NO_EMPTY!!!
        $employeeNames = preg_split('/[,\s]+/', $input[0]);
        $employeeNames = array_filter($employeeNames, function ($element) {
            return $element !== '';
        });
        $employeeInsertData = explode(', ', $input[1]);

        if (count($employeeNames) == 4) {
            // employee_id is supplied, checking for single employee
            $this->checkForSingleEmployee($employeeNames, $employeeInsertData, $emailOrPhone);
        } else {
            // just the names are supplied, checking for more than one employee with the names
            $this->checkForMultipleEmployees($employeeNames, $employeeInsertData, $emailOrPhone);
        }
    }

    /**
     * Checks if an employee with the params exists in the table with
     * $employee_id, first_name, middle_name, last_name
     *
     * @param   array       $employeeNames
     * @param   array       $employeeInsertData
     * @param   string      $emailOrPhone
     * @throws  \Exception
     */
    private function checkForSingleEmployee(array $employeeNames, array $employeeInsertData, string $emailOrPhone)
    {
        $employeeId     = intval($employeeNames[0]);
        $firstName      = $employeeNames[1];
        $middleName     = $employeeNames[2];
        $lastName       = $employeeNames[3];

        // If there isn't any Employee in the database - throw an Exception
        if (!$this->getDatabase()->employeeExists(
            $firstName,
            $middleName,
            $lastName,
            $employeeId,
            parent::SEARCH_TABLE_ID
        )
        ) {
            throw new \Exception(
                'Employee ' . $firstName . ' ' . $middleName . ' ' . $lastName . ' with ID: ' . $employeeId . ' doesn\' exist.' . PHP_EOL
            );
        }

        // If there is - try to insert it's Email or Phone information
        $this->insertData($firstName, $lastName, $employeeId, $employeeInsertData, $emailOrPhone);
    }

    /**
     * Checks if there are any employees with the provided params using
     * first_name, middle_name, last_name
     *
     * @param   array       $employeeNames
     * @param   array       $employeeData
     * @param   string      $option
     * @throws  \Exception
     */
    private function checkForMultipleEmployees(array $employeeNames, array $employeeData, string $option)
    {
        $firstName  = $employeeNames[0];
        $middleName = $employeeNames[1];
        $lastName   = $employeeNames[2];

        $employeeIds = $this->getDatabase()->findEmployeesByName(
            $firstName,
            parent::SEARCH_NAMES_EXACT,
            $lastName,
            $middleName
        );

        if (count($employeeIds) == 0) {
            // No Employees found in the table - throw Exception
            throw new \Exception(
                'No employees with the name ' . $firstName . ' ' . $middleName . ' ' . $lastName . ' found!' . PHP_EOL
            );

        } else if (count($employeeIds) == 1) {
            // If only 1 Employee is present - try to insert it's Email or Phone information
            $this->insertData($firstName, $lastName, intval($employeeIds[0]), $employeeData, $option);

        } else {
            // If multiple Employees found - list each's employee_id
            exit('Employees with this name: ' . implode(', ', $employeeIds) . PHP_EOL);
        }
    }

    /**
     * Tries to insert the Employee's
     * Phone or Email information in the database
     *
     * @param string    $firstName
     * @param string    $lastName
     * @param int       $employeeId
     * @param array     $employeeData
     * @param string    $emailOrPhone
     */
    private function insertData(
        string  $firstName,
        string  $lastName,
        int     $employeeId,
        array   $employeeData,
        string  $emailOrPhone
    )
    {
        // Checks if any Emails or Phones are inserted in the database to print a message at the end
        $savedAnyEmails = false;

        // Walks through each Email or Phone (type: Address|Number) and tries to insert them in the Database
        foreach ($employeeData as $employeeDataInfo) {
            $dataInfo = explode(': ', $employeeDataInfo);

            $dataType = trim($dataInfo[0]);
            $dataAddressOrNumber = trim($dataInfo[1]);

            // If the Email Address or Phone Number is present in the table continue without throwing Exception
            if ($this->getDatabase()->dataExists($dataAddressOrNumber, $emailOrPhone)) {
                echo $emailOrPhone . ' ' . $dataAddressOrNumber . ' exists! Skipping!' . PHP_EOL;
                continue;
            }

            $this->getDatabase()->insertEmployeeData($employeeId, $dataAddressOrNumber, $dataType, $emailOrPhone);
        }

        if ($savedAnyEmails) {
            echo 'Emails of ' . $firstName . ' ' . $lastName . ' saved.' . PHP_EOL;
        }
    }
}