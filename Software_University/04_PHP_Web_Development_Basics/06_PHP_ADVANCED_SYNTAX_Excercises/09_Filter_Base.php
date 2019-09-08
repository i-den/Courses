<?php

$peopleAge = array();
$peoplePosition = array();
$peopleSalary = array();

while (true) {
    $input = explode(' -> ', trim(fgets(STDIN)));

    if ($input[0] === 'filter base') {
        break;
    }

    $name = $input[0];
    $personCurrInfo = $input[1];

    if (filter_var($personCurrInfo, FILTER_VALIDATE_INT)) {
        $peopleAge[$name] = intval($personCurrInfo);
    } else if (filter_var($personCurrInfo, FILTER_VALIDATE_FLOAT)) {
        $float = round(floatval($personCurrInfo), 2);
        $peopleSalary[$name] = number_format($float, 2, '.', '');
    } else {
        $peoplePosition[$name] = $personCurrInfo;
    }
}

$printRequest = strtolower(trim(fgets(STDIN)));

switch ($printRequest) {
    case 'age':
        printPeople($peopleAge, 'Age');
        return;
    case 'salary':
        printPeople($peopleSalary, 'Salary');
        return;
    default:
        printPeople($peoplePosition, 'Position');
        return;
}

function printPeople(array $peopleArr, string $criteria)
{
    foreach ($peopleArr as $person => $info) {
        echo 'Name: ' .$person . PHP_EOL;
        echo $criteria . ': ' . $info . PHP_EOL;
        echo str_repeat('=', 20) . PHP_EOL;
    }
}
