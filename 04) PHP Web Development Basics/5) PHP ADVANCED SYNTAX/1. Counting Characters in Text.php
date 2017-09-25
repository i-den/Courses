<?php

$inputText = str_replace(' ', '', strtolower(trim(fgets(STDIN))));
$outputArr = array();

for ($i = 0; $i < strlen($inputText); $i++) {
    $currentChar = $inputText[$i];

    if (!isset($outputArr[$currentChar])) {
        $outputArr[$currentChar] = 0;
    }

    $outputArr[$currentChar]++;
}

$outputString = array();
foreach ($outputArr as $currChar => $currCharOccurrences) {
    $outputString[] = "\"$currChar\" => \"$currCharOccurrences\"";
}

echo '[' . implode($outputString, ', ') . ']';
