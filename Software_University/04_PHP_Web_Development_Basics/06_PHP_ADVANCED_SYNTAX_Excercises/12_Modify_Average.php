<?php

$inputNumber = trim(fgets(STDIN));


while (true) {
    $numberDigitsAvg = getAverage($inputNumber);
    if ($numberDigitsAvg > 5) {
        break;
    }

    $inputNumber .= '9';
}

echo $inputNumber . PHP_EOL;

function getAverage(string $num) : float
{
    $sum = 0.0;

    for ($i = 0; $i < strlen($num); $i++) {
        $sum += floatval($num[$i]);
    }

    $sum /= strlen($num);
    return $sum;
}
