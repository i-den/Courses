<?php


namespace Core\Service\Commands;


use Core\Adapter\TotallyDoctrine;
use Models\Employee;

class SecondCommand extends Command
{
    public function __construct(TotallyDoctrine $database)
    {
        parent::__construct($database);
    }

    public function execute()
    {
        $employeeInfo = explode(', ', trim(fgets(STDIN)));

        if (count($employeeInfo) !== 6) {
            throw new \Exception('Error: Please, check your input syntax.');
        }

        $firstName = $employeeInfo[0];
        $middleName = $employeeInfo[1];
        $lastName = $employeeInfo[2];
        $department = $employeeInfo[3];
        $position = $employeeInfo[4];
        $passId = explode(' ', $employeeInfo[5])[1];

        $employee = new Employee(
            $firstName,
            $middleName,
            $lastName,
            $department,
            $position,
            $passId
        );

        if ($this->getDatabase()->employeeExists($firstName, $middleName, $lastName, $passId)) {
            throw new \Exception(
                'Employee ' . $firstName . ' ' . $middleName . ' ' . $lastName . ' already exists!' . PHP_EOL
            );
        }

        $this->getDatabase()->insertEmployee($employee);

        exit('New employee ' . $firstName . ' ' . $middleName . ' ' . $lastName . ' saved.' . PHP_EOL);
    }
}
