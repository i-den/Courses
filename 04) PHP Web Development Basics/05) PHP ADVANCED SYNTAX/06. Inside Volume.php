<?php

$input = array_map('floatval', explode(', ', trim(fgets(STDIN))));

$boxToCheck = array(
    'x' => array(
        'min' => 10,
        'max' => 50
    ),
    'y' => array(
        'min' => 20,
        'max' => 80
    ),
    'z' => array(
        'min' => 15,
        'max' => 50
    )
);

for ($i = 0; $i < count($input); $i += 3) {
    $inputSideX = $input[$i];
    $inputSideY = $input[$i + 1];
    $inputSideZ = $input[$i + 2];

    echo isInsideVolume($inputSideX, $inputSideY, $inputSideZ, $boxToCheck)
        ? 'inside' . PHP_EOL
        : 'outside' . PHP_EOL;
}

function isInsideVolume($x, $y, $z, $box)
{
    if (isInsideSide($x, $box['x']['min'], $box['x']['max'])
        && isInsideSide($y, $box['y']['min'], $box['y']['max'])
        && isInsideSide($z, $box['z']['min'], $box['z']['max'])
    ) {
        return true;
    }

    return false;
}

function isInsideSide($side, $minVal, $maxVal)
{
    return $side >= $minVal && $side <= $maxVal;
}
