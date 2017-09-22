<?php

$input = fgets(STDIN);
$endIndex = intval($input) < 999
    ? intval($input)
    : 999;
$found = false;
$legitNumbers = array();

for ($i = 102; $i <= $endIndex; $i++) {
    if (checkNumberForUniques($i)) {
        $legitNumbers[] = $i;

        $found = true;
    }
}

if ($found) {
    echo implode(', ', $legitNumbers);
} else {
    echo 'no';
}

function checkNumberForUniques($number) {
    $numbers = str_split($number);
    $existingNumbers = array();

    for ($i = 0; $i < count($numbers); $i++) {
        if (in_array($numbers[$i], $existingNumbers)) {
            return false;
        }

        $existingNumbers[] = $numbers[$i];
    }

    return true;
}
