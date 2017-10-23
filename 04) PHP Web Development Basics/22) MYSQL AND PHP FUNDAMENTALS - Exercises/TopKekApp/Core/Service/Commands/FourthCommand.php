<?php


namespace Core\Service\Commands;


use Core\Adapter\TotallyDoctrine;

class FourthCommand extends Command
{
    public function __construct(TotallyDoctrine $database)
    {
        parent::__construct($database);
    }

    public function execute(array $options = null)
    {
        $input = explode(', ', trim(fgets(STDIN)));

        $firstName = $input[1];
        $lastName = $input[2];

        $employeeIds = $this->getDatabase()->findEmployeesByName($firstName, $lastName);

        if (count($employeeIds) == 0) {
            throw new \Exception(
                'No employees with the name ' . $firstName . ' ' . $lastName . ' found!' . PHP_EOL
            );
        }

        foreach ($employeeIds as $employeeId) {
            $employee = $this->getDatabase()->fetchEmployeeById($employeeId);
            echo 'Information About Employee with ID ' . $employeeId . ':' . PHP_EOL;
            echo $employee . PHP_EOL;
        }
    }
}