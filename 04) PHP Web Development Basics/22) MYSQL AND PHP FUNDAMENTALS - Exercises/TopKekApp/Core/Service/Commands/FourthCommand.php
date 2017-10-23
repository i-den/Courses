<?php


namespace Core\Service\Commands;


use Core\Adapter\TotallyDoctrine;

/**
 * Class FourthCommand
 *
 * Responsible for outputting information
 * about and Employee on the Console
 *
 * @package Core\Service\Commands
 */
class FourthCommand extends Command
{
    public function __construct(TotallyDoctrine $database)
    {
        parent::__construct($database);
    }

    /**
     * Takes an Input with information
     * about an Employee and tries
     * to list information about it
     *
     * @param   array|null      $options
     * @throws  \Exception
     */
    public function execute(array $options = null)
    {
        $input = explode(', ', trim(fgets(STDIN)));
        $employeeIds = null;

        // Checks if WildCard is used
        switch (count($input)) {
            // No WildCard, regular Search for Employee
            case 3:
                $firstName = $input[1];
                $lastName = $input[2];

                $employeeIds = $this->getDatabase()->findEmployeesByName(
                    $firstName,
                    parent::SEARCH_NAMES_EXACT,
                    $lastName
                );

                break;

            // WildCard Search for an Employee
            default:
                $name = rtrim($input[1], '*');
                $employeeIds = $this->getDatabase()->findEmployeesByName(
                    $name,
                    parent::SEARCH_NAMES_WILDCARD
                );
                break;
        }

        // If none are found throw an Exception
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
