<?php

declare(strict_types=1);

$result = '';

if (isset($_GET['Go'])
    && isset($_GET['firstNumber'])
    && isset($_GET['secondNumber'])
    && isset($_GET['operation'])
) {
    $operation = trim($_GET['operation']);
    $firstNumber = trim($_GET['firstNumber']);
    $secondNumber = trim($_GET['secondNumber']);

    $inputArray = array(
        [$operation, $firstNumber, $secondNumber]
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

    $calculate = function (callable &$calculate, array $inputArray, int $i = 0, string $output = '') use ($opSum, $opSub, $opMultiply, $opDivide) {
        if ($i < count($inputArray)) {
            $operation = $inputArray[$i][0];
            $firstNumber = $inputArray[$i][1];
            $secondNumber = $inputArray[$i][2];

            if (!is_numeric($firstNumber)) {
                $output .= 'op1_not_numeric';
                return $calculate($calculate, $inputArray, $i + 1, $output);
            } else if (!is_numeric($secondNumber)) {
                $output .= 'op2_not_numeric';
                return $calculate($calculate, $inputArray, $i + 1, $output);
            } else if ($firstNumber < 0 || $firstNumber > 100 || $secondNumber < 0 || $secondNumber > 100) {
                $output .= 'out_of_range';
                return $calculate($calculate, $inputArray, $i + 1, $output);
            } else if ((float)$secondNumber === 0.0) {
                $output .= 'division_by_zero';
                return $calculate($calculate, $inputArray, $i + 1, $output);
            }

            $firstNumber = (float)$firstNumber;
            $secondNumber = (float)$secondNumber;

            switch ($operation) {
                case 'sum':
                    $output .= $opSum($firstNumber, $secondNumber);
                    return $calculate($calculate, $inputArray, $i + 1, $output);
                case 'subtract':
                    $output .= $opSub($firstNumber, $secondNumber);
                    return $calculate($calculate, $inputArray, $i + 1, $output);
                case 'multiply':
                    $output .= $opMultiply($firstNumber, $secondNumber);
                    return $calculate($calculate, $inputArray, $i + 1, $output);
                case 'divide':
                    $output .= $opDivide($firstNumber, $secondNumber);
                    return $calculate($calculate, $inputArray, $i + 1, $output);
            }

            return $calculate($calculate, $inputArray, $i + 1, $output);
        }

        return $output;
    };

    $result = $calculate($calculate, $inputArray);
}

include('./calculator_frontend.php');
