<?php

$inputElements = explode(', ', trim(fgets(STDIN)));
$elementsCountArr = array();

foreach ($inputElements as $element) {
    if (!isset($elementsCountArr[$element])) {
        $elementsCountArr[$element] = 0;
    }

    $elementsCountArr[$element]++;
}

$uniquesArr = array_keys(array_filter($elementsCountArr, function ($currArrValue) {
    return $currArrValue === 1;
}));

echo implode(' ', $uniquesArr);
