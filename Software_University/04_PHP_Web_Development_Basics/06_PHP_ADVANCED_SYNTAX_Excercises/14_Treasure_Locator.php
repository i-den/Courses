<?php

$inputCoordinates = array_map('floatval', explode(', ', trim(fgets(STDIN))));
$islandCoordinates = array(
    'Tokelau' => array(
        'minX' => 8,
        'maxX' => 9,
        'minY' => 0,
        'maxY' => 1
    ),
    'Tuvalu' => array(
        'minX' => 1,
        'maxX' => 3,
        'minY' => 1,
        'maxY' => 3
    ),
    'Samoa' => array(
        'minX' => 5,
        'maxX' => 7,
        'minY' => 3,
        'maxY' => 6
    ),
    'Tonga' => array(
        'minX' => 0,
        'maxX' => 2,
        'minY' => 6,
        'maxY' => 8
    ),
    'Cook' => array(
        'minX' => 4,
        'maxX' => 9,
        'minY' => 7,
        'maxY' => 8
    )
);

for ($i = 0; $i < count($inputCoordinates); $i += 2) {
    $firstCoordinate = $inputCoordinates[$i];
    $secondCoordinate = $inputCoordinates[$i + 1];

    echo isInsideAnIsland($firstCoordinate, $secondCoordinate, $islandCoordinates);
}

function isInsideAnIsland($x, $y, $islandCoordinates)
{
    foreach ($islandCoordinates as $name => $info) {
        $axisX = ($islandCoordinates[$name]['minX'] <= $x && $x <= $islandCoordinates[$name]['maxX']);
        $axisY = ($islandCoordinates[$name]['minY'] <= $y && $y <= $islandCoordinates[$name]['maxY']);

        if ($axisX && $axisY) {
            return $name . PHP_EOL;
        }
    }

    return 'On the bottom of the ocean' . PHP_EOL;
}
