<?php

$arr = array(
    'Sofia',
    20,
    'Varna',
    10,
    'Sofia',
    5
);

$sums = array();

$arrMaxIndice = count($arr);
for ($i = 0; $i < $arrMaxIndice; $i += 2) {
    if (!array_key_exists($arr[$i], $sums)) {
        $sums[$arr[$i]] = 0;
    }

    $sums[$arr[$i]] += $arr[$i + 1];
}

var_dump($sums);
