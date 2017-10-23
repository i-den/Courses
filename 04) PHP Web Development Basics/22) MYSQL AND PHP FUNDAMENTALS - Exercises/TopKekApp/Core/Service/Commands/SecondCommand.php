<?php


namespace Core\Service\Commands;


use Core\Adapter\TotallyDoctrine;
use Models\Employee;

/**
 * Class SecondCommand
 *
 * Responsible for Inserting
 * Employees in the Database
 *
 * @package Core\Service\Commands
 */
class SecondCommand extends Command
{

    public function __construct(TotallyDoctrine $database)
    {
        parent::__construct($database);
    }

    /**
     * Takes input and tries to Insert
     * an Employee instance in the Database
     *
     * @param array|null $options
     * @throws \Exception
     */
    public function execute(array $options = null)
    {
        $employeeInfo = explode(', ', trim(fgets(STDIN)));

        if (count($employeeInfo) < 6 ) {
            throw new \Exception('Error: Please, check your input syntax.');
        }

        $firstName = $employeeInfo[0];
        $middleName = $employeeInfo[1];
        $lastName = $employeeInfo[2];
        $department = $employeeInfo[3];
        $position = $employeeInfo[4];
        $passId = explode(' ', $employeeInfo[5])[1];
        $country = null;
        $database = $this->getDatabase();

        // Check if there is a Valid Country to be Inserted
        if (count($employeeInfo) == 7) {
            $country = $database->findCountry($employeeInfo[6]);
            if ($country == null) {
                throw new \Exception('No such country found - ' . $employeeInfo[6] . PHP_EOL);
            }
        }


        $employee = new Employee(
            $firstName,
            $middleName,
            $lastName,
            $department,
            $position,
            $passId,
            $country
        );

        // If an Employee with unique combination of names and passport_id exists throw an Exception
        if ($database->employeeExists(
            $firstName,
            $middleName,
            $lastName,
            $passId,
            parent::SEARCH_PASS_ID
        )
        ) {
            throw new \Exception(
                'Employee ' . $firstName . ' ' . $middleName . ' ' . $lastName . ' already exists!' . PHP_EOL
            );
        }

        $database->insertEmployee($employee);

        exit('New employee ' . $firstName . ' ' . $middleName . ' ' . $lastName . ' saved.' . PHP_EOL);
    }
}
