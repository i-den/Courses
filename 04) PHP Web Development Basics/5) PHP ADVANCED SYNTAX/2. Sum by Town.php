<?php

$inputTownsIncome = explode(', ', trim(fgets(STDIN)));
$townsTotalIncome = array();

for ($i = 0; $i < count($inputTownsIncome); $i += 2) {
    $town = $inputTownsIncome[$i];
    $income = intval($inputTownsIncome[$i + 1]);

    if (!isset($townsTotalIncome[$town])) {
        $townsTotalIncome[$town] = 0;
    }

    $townsTotalIncome[$town] += $income;
}

$outputString = array();

foreach ($townsTotalIncome as $town => $income) {
    $outputString[] = "\"$town\" => \"$income\"";
}

echo '[' . implode(', ', $outputString) . ']';
