<?php

$word = $argv[1];

$wordLetters = str_replace(' ', '', $word);
$wordLetters = str_split($wordLetters);

$letters = [];

foreach ($wordLetters as $currentLetter) {
    if (!array_key_exists($currentLetter, $letters)) {
        $letters[$currentLetter] = 0;
    }

    $letters[$currentLetter]++;
}

foreach ($letters as $letter => $value) {
    echo "$letter -> $value\n";
}
