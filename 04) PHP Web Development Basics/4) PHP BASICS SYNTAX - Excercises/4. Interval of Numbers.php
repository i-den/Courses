<?php

$firstNumber = intval(fgets(STDIN));
$secondNumber = intval(fgets(STDIN));

$start = min($firstNumber, $secondNumber);
$end = max($firstNumber, $secondNumber);

echo "Starting count from $start to $end:\n";

for ($i = $start; $i <= $end; $i++) {
    echo "$i\n";
}
