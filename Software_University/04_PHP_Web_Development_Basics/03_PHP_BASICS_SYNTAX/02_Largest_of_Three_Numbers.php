<?php

$numberOne = intval(fgets(STDIN));
$numberTwo = intval(fgets(STDIN));
$numberThree = intval(fgets(STDIN));

$maxNumber = max($numberOne, $numberTwo, $numberThree);

echo "Max: $maxNumber";
