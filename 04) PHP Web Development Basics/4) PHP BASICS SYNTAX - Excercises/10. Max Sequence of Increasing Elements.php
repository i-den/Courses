<?php

$inputArray = trim(fgets(STDIN));
$inputArray = array_map('intval', explode(' ', $inputArray));

$startingIndex = 0;
$globalMaxSequence = 1;

for ($i = 0; $i < count($inputArray) - 1; $i++) {
    $currentMaxSequence = 1;
    $toBeBigger = 1;

    for ($j = $i + 1; $j < count($inputArray); $j++) {
        if ($inputArray[$j] - $toBeBigger === $inputArray[$i]) {
            $currentMaxSequence++;
            $toBeBigger++;

            if ($currentMaxSequence > $globalMaxSequence) {
                $globalMaxSequence = $currentMaxSequence;
                $startingIndex = $i;
            }
        } else  {
            break;
        }
    }
}

for ($i = $startingIndex; $i < $startingIndex + $globalMaxSequence; $i++) {
    echo "$inputArray[$i] ";
}
