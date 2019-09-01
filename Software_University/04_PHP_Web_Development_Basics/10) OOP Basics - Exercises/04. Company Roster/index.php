<?php

include './Employee.php';

use Van\Classes\Employee;

$employeeCount = intval(trim(fgets(STDIN)));
$employees = array();
$departmentsAvgSalary = array();

for ($i = 0; $i < $employeeCount; $i++) {
    $input = explode(' ', trim(fgets(STDIN)));

    $name = $input[0];
    $salary = floatval($input[1]);
    $position = $input[2];
    $department = $input[3];

    $employee = new Employee($name, $salary, $position, $department);

    if (count($input) >= 5) {
        for ($j = 4; $j < count($input); $j++) {
            $extraInfo = $input[$j];

            if (preg_match('/\b(\d+)\b/', $extraInfo)) {
                $employee->setAge(intval($extraInfo));
            } else {
                $employee->setEmail($extraInfo);
            }
        }
    }

    $employees[] = $employee;
}

foreach ($employees as $employee) {
    $department = $employee->getDepartment();
    $salary = $employee->getSalary();

    if (!array_key_exists($department, $departmentsAvgSalary)) {
        $departmentsAvgSalary[$department] = 0;
    }

    $departmentsAvgSalary[$department] += $salary;
}

arsort($departmentsAvgSalary, SORT_NUMERIC);

reset($departmentsAvgSalary);
$highestPaidDeparment = key($departmentsAvgSalary);

usort($employees, function (Employee $firstEmployee, Employee $secondEmployee) {
    return $firstEmployee->getSalary() < $secondEmployee->getSalary();
});

echo 'Highest Average Salary: ' . $highestPaidDeparment . PHP_EOL;
foreach ($employees as $employee) {
    $employee->printStats($highestPaidDeparment);
}
