<?php

$firstNumbers = array(2, 1.567808, 1234.5678);
$secondNumber = array(5, 0.356, 333);

for ($i = 0; $i < count($firstNumbers); $i++) {
    $result = sumTwoNumbers($firstNumbers[$i], $secondNumber[$i]);
    echo $result . "\n";
}


function sumTwoNumbers($firstNumber, $secondNumber) {
    $sum = $firstNumber + $secondNumber;
    $result = round($sum, 2);

    return $result;
}
