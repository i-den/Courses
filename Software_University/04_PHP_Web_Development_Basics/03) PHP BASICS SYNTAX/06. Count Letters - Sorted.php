<?php

$word = $argv[1];
$letters = array();

for ($i = 0; $i < strlen($word); $i++) {
    $currentLetter = $word[$i];

    if (!array_key_exists($currentLetter, $letters)) {
        $letters[$currentLetter] = 0;
    }

    $letters[$currentLetter]++;
}

arsort($letters);

foreach ($letters as $letter => $value) {
    echo "$letter -> $value\n";
}