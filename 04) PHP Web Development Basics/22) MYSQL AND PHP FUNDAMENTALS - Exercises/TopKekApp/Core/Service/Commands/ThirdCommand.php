<?php


namespace Core\Service\Commands;


use Core\Adapter\TotallyDoctrine;

class ThirdCommand extends Command
{
    const GIVE_ID = 2;

    public function __construct(TotallyDoctrine $database)
    {
        parent::__construct($database);
    }

    public function execute(array $options = null)
    {
        $option = $options[0];
        $split = strtolower($option) . 's';
        $input = explode($split . ', ', trim(fgets(STDIN)));

        // F*ck you preg_split PREG_SPLIT_NO_EMPTY!!!
        $employeeNames = preg_split('/[,\s]+/', $input[0]);
        $employeeNames = array_filter($employeeNames, function ($element) {
            return $element !== '';
        });
        $employeeInsertData = explode(', ', $input[1]);

        if (count($employeeNames) == 4) {
            $this->checkForSingleEmployee($employeeNames, $employeeInsertData, $option);
        } else {
            $this->checkForMultipleEmployees($employeeNames, $employeeInsertData, $option);
        }
    }

    private function checkForSingleEmployee(array $employeeNames, array $employeeInsertData, string $option)
    {
        $employeeId = intval($employeeNames[0]);
        $firstName = $employeeNames[1];
        $middleName = $employeeNames[2];
        $lastName = $employeeNames[3];

        if (!$this->getDatabase()->employeeExists(
            $firstName,
            $middleName,
            $lastName,
            $employeeId,
            self::GIVE_ID
        )
        ) {
            throw new \Exception(
                'Employee ' . $firstName . ' ' . $middleName . ' ' . $lastName . ' with ID: ' . $employeeId . ' doesn\' exist.' . PHP_EOL
            );
        }

        $this->insertData($firstName, $lastName, $employeeId, $employeeInsertData, $option);
    }

    private function checkForMultipleEmployees(array $employeeNames, array $employeeData, string $option)
    {
        $firstName  = $employeeNames[0];
        $middleName = $employeeNames[1];
        $lastName   = $employeeNames[2];


        $employeeIds = $this->getDatabase()->findEmployeesByName(
            $firstName, $lastName, $middleName
        );

        if (count($employeeIds) == 0) {
            throw new \Exception(
                'No employees with the name ' . $firstName . ' ' . $middleName . ' ' . $lastName . ' found!' . PHP_EOL
            );
        } else if (count($employeeIds) == 1) {
            $this->insertData($firstName, $lastName, intval($employeeIds[0]), $employeeData, $option);
        } else {
            exit('Employees with this name: ' . implode(', ', $employeeIds) . PHP_EOL);
        }
    }

    private function insertData(
        string  $firstName,
        string  $lastName,
        int     $employeeId,
        array   $employeeData,
        string  $option
    )
    {
        $savedAnyEmails = false;
        foreach ($employeeData as $employeeDataInfo) {
            $dataInfo = explode(': ', $employeeDataInfo);

            $dataType = trim($dataInfo[0]);
            $dataAddressOrNumber = trim($dataInfo[1]);

            if ($this->getDatabase()->dataExists($dataAddressOrNumber, $option)) {
                echo $option . ' ' . $dataAddressOrNumber . ' exists! Skipping!' . PHP_EOL;
                continue;
            }

            $this->getDatabase()->insertEmployeeData($employeeId, $dataAddressOrNumber, $dataType, $option);
        }
        if ($savedAnyEmails) {
            echo 'Emails of ' . $firstName . ' ' . $lastName . ' saved.' . PHP_EOL;
        }
    }
}