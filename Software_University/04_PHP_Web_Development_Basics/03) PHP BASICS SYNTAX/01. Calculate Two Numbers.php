<?php

$operator = $argv[1];
$result = '';

$numberOne = intval(fgets(STDIN));
$numberTwo = intval(fgets(STDIN));

switch ($operator) {
    case 'sum':
      $result = $numberOne + $numberTwo;
      break;
    case 'subtract':
        $result = $numberOne - $numberTwo;
        break;
    default:
        $result = 'Wrong operation supplied';
        break;
}

echo ' == ' . $result;
