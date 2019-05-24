<?php

declare(strict_types=1);

$input = array(
    ['sum', 12, 156],
    ['subtract', 5, 6],
    ['subtract', 1, 2],
    ['sum', 12, 13],
    ['subtract', 3, 3],
    ['sum', 1, 2]
);

$calcTwoNumbers = function (float $firstNumber, float $secondNumber, string $operation) : float {
    if ($operation === 'subtract') {
        $secondNumber *= -1;
    }
    return $firstNumber + $secondNumber;
};

$calculate = function (callable &$calculate, array $inputArray, int $i = 0, array $output = []) use ($calcTwoNumbers) {
    if ($i < count($inputArray)) {
        $operation = $inputArray[$i][0];
        $firstNumber = floatval($inputArray[$i][1]);
        $secondNumber = floatval($inputArray[$i][2]);

        if ($firstNumber < 0 || $firstNumber > 100 || $secondNumber < 0 || $secondNumber > 100) {
            $output[] = 'error';
            return $calculate($calculate, $inputArray, $i + 1, $output);
        }

        $output[] = $calcTwoNumbers($firstNumber, $secondNumber, $operation);
        return $calculate($calculate, $inputArray, $i + 1, $output);
    }

    return $output;
};

printResult($calculate($calculate, $input));

function printResult($inputArray) : void
{
    echo '[';
    echo implode(', ', $inputArray);
    echo ']';
}
