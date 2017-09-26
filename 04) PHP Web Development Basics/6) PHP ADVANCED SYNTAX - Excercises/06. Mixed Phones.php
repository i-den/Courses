<?php

$outputArr = array();

while (true) {
    $input = explode(' : ', trim(fgets(STDIN)));

    if ($input[0] == 'Over') {
        break;
    }

    $name = '';
    $number = '';

    if (preg_match('/\b[\d]+\b/', $input[0])) {
        $number = $input[0];
        $name = $input[1];
    } else {
        $number = $input[1];
        $name = $input[0];
    };

    $outputArr[$name] = $number;
}

ksort($outputArr);

foreach ($outputArr as $name => $number) {
    echo $name . ' -> ' . $number . PHP_EOL;
}
