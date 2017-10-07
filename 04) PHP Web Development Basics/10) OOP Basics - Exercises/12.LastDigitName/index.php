<?php

include './Number.php';

use Van\Classes\Number;

$number = intval(fgetc(STDIN));

$lastDigit = new Number($number);

echo $lastDigit->getLastDigitAsChar();

