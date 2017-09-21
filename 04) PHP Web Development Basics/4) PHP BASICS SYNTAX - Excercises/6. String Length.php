<?php

$inputString = trim(fgets(STDIN));

if (strlen($inputString) > 20) {
    $inputString = substr($inputString, 0, 20);
}

$inputString = str_pad($inputString, 20, '*');

echo $inputString;
