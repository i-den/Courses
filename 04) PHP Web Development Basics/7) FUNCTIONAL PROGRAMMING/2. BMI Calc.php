<?php

$people = [
    ['name' => 'John', 'weight' => 69, 'height' => 1.69],
    ['name' => 'Peter', 'weight' => 85, 'height' => 1.68],
    ['name' => 'Ivan', 'weight' => 75, 'height' => 1.72],
    ['name' => 'Mitko', 'weight' => 95, 'height' => 1.70]
];

$bmiCalc = array_map(function ($element) {
    return array(
        'name' => $element['name'],
        'bmi' => $element['weight'] / (pow($element['height'], 2))
    );
}, $people);


$avgValue = 0;
$bmiCalcAvg = array_reduce($bmiCalc, function ($a, $b) use ($avgValue) {
    if (($a['bmi'] + $b['bmi']) / 2 > $avgValue) {
        return $a['bmi'] + $b['bmi'] / 2;
    }
});

