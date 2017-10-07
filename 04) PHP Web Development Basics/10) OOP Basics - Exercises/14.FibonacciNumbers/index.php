<?php

include "./Fibonacci.php";

use Van\Classes\Fibonacci;

$startNumber = intval(fgets(STDIN));
$endingNumber = intval(fgets(STDIN));

$fibonacciNumber = new Fibonacci($startNumber, $endingNumber);

echo implode(', ', $fibonacciNumber->getFibonacciSequence());