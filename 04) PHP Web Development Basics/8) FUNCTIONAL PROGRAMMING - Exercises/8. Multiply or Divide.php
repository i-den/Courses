<?php

declare(strict_types=1);

$input = array(
    ['sum', 12, 156],
    ['subtract', 5, 6],
    ['subtract', 1, 2],
    ['sum', 12, 13],
    ['subtract', 3, 3],
    ['sum', 1, 2],
    ['divide', 100, 0],
    ['divide', 100, 'PP'],
    ['sum', 'P123', 123]
);

$opSum = function (float $a, float $b): float {
    return $a + $b;
};

$opSub = function (float $a, float $b): float {
    return $a - $b;
};

$opMultiply = function (float $a, float $b): float {
    return $a * $b;
};

$opDivide = function (float $a, float $b): float {
    return $a / $b;
};

$calculate = function (callable &$calculate, array $inputArray, int $i = 0, array $output = []) use ($opSum, $opSub, $opMultiply, $opDivide) {
    if ($i < count($inputArray)) {
        $operation = $inputArray[$i][0];
        $firstNumber = $inputArray[$i][1];
        $secondNumber = $inputArray[$i][2];

        if (!is_numeric($firstNumber)) {
            $output[] = 'op1_not_numeric';
            return $calculate($calculate, $inputArray, $i + 1, $output);
        } else if (!is_numeric($secondNumber)) {
            $output[] = 'op2_not_numeric';
            return $calculate($calculate, $inputArray, $i + 1, $output);
        } else if ($firstNumber < 0 || $firstNumber > 100 || $secondNumber < 0 || $secondNumber > 100) {
            $output[] = 'out_of_range';
            return $calculate($calculate, $inputArray, $i + 1, $output);
        } else if ((float)$secondNumber === 0.0) {
            $output[] = 'division_by_zero';
            return $calculate($calculate, $inputArray, $i + 1, $output);
        }

        switch ($operation) {
            case 'sum':
                $output[] = $opSum($firstNumber, $secondNumber);
                return $calculate($calculate, $inputArray, $i + 1, $output);
            case 'subtract':
                $output[] = $opSub($firstNumber, $secondNumber);
                return $calculate($calculate, $inputArray, $i + 1, $output);
            case 'multiply':
                $output[] = $opMultiply($firstNumber, $secondNumber);
                return $calculate($calculate, $inputArray, $i + 1, $output);
            case 'divide':
                $output[] = $opDivide($firstNumber, $secondNumber);
                return $calculate($calculate, $inputArray, $i + 1, $output);
        }

        return $calculate($calculate, $inputArray, $i + 1, $output);
    }

    return $output;
};

printResult($calculate($calculate, $input));

function printResult($inputArray): void
{
    echo '[';
    echo implode(', ', $inputArray);
    echo ']';
}
