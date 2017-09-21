<?php

$inputString = trim(fgets(STDIN));
$inputArgs = explode(' ', trim(fgets(STDIN)));

$letter = $inputArgs[0];
$number = intval($inputArgs[1]);

$index = '';
$currentOffset = 0;

for ($i = 0; $i < $number; $i++) {
    if (strpos($inputString, $letter, $currentOffset) !== false) {
        $index = strpos($inputString, $letter, $currentOffset);
        $currentOffset = $index + 1;
    } else {
        echo 'Find the letter yourself!';
        exit;
    }
}

echo $index;
