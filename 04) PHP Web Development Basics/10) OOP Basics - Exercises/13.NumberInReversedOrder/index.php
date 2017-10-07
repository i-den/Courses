<?php

include "./DecimalNumber.php";

use Van\Classes\DecimalNumber;

$number = new DecimalNumber(trim(fgets(STDIN)));

echo $number->getReversedString();