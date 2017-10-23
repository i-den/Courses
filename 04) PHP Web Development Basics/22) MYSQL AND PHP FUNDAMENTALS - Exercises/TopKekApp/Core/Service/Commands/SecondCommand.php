<?php


namespace Core\Service\Commands;


use Core\Adapter\TotallyDoctrine;
use Models\Employee;

class SecondCommand extends Command
{
    const GIVE_PASS_ID = 1;

    public function __construct(TotallyDoctrine $database)
    {
        parent::__construct($database);
    }

    public function execute(array $options = null)
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
        $database = $this->getDatabase();
        $employee = new Employee(
            $firstName,
            $middleName,
            $lastName,
            $department,
            $position,
            $passId
        );

        if ($database->employeeExists(
            $firstName,
            $middleName,
            $lastName,
            $passId,
            self::GIVE_PASS_ID
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
