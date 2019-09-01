<?php
//shtot nqkoi, nqkoga pazi floatove kat keyove.. br e
$inputNumbers = explode(' ', trim(fgets(STDIN)));

$numbersValueArr = array();

foreach ($inputNumbers as $currNumber) {
    if (!isset($numbersValueArr[$currNumber])) {
        $numbersValueArr[$currNumber] = 0;
    }

    $numbersValueArr[$currNumber]++;
}

ksort($numbersValueArr);

foreach ($numbersValueArr as $number => $value) {
    echo $number . ' -> ' . $value . ' times' . PHP_EOL;
}
