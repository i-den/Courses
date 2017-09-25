<?php

$inputSpeed = intval(trim(fgets(STDIN)));
$inputArea = trim(fgets(STDIN));

echo roadRadarCheck($inputSpeed, $inputArea);

function roadRadarCheck($speed, $area) {
    $areaLimits = array(
        'motorway' => 130,
        'interstate' => 90,
        'city' => 50,
        'residential' => 20
    );

    $speedAboveLimit = $speed - $areaLimits[$area];
    $result = '';

    if ($speedAboveLimit >= 0 && $speedAboveLimit <= 20) {
        $result = 'speeding';
    } else if ($speedAboveLimit > 20 && $speedAboveLimit <= 40) {
        $result = 'excessive speeding';
    } else if ($speedAboveLimit > 40) {
        $result = 'reckless driving';
    }

    return $result;
}
