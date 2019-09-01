<?php

$inputString = trim(fgets(STDIN));
$charValueArr = array();

for ($i = 0; $i < strlen($inputString); $i++) {
    $currChar = $inputString[$i];

    if (!isset($charValueArr[$currChar])) {
        $charValueArr[$currChar] = 0;
    }

    $charValueArr[$currChar]++;
}

foreach ($charValueArr as $char => $value) {
    echo $char . ' -> ' . $value . PHP_EOL;
}
