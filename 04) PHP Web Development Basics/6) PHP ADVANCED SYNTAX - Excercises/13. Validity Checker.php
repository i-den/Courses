<?php

$inputCoordinates = array_map('intval', explode(', ', trim(fgets(STDIN))));

$points = array(
    array(
        'x' => $inputCoordinates[0],
        'y' => $inputCoordinates[1]
    ),
    array(
        'x' => $inputCoordinates[2],
        'y' => $inputCoordinates[3]
    )
);

for ($i = 0; $i < 2; $i++) {
    if (isDistanceBtwPtsValid($points[$i]['x'], $points[$i]['y'], 0, 0)) {
        printSuccess($points[$i]['x'], $points[$i]['y'], 0, 0);
    }
}

if (isDistanceBtwPtsValid($points[0]['x'], $points[0]['y'], $points[1]['x'], $points[1]['y'])) {
    printSuccess($points[0]['x'], $points[0]['y'], $points[1]['x'], $points[1]['y']);
}

function isDistanceBtwPtsValid(
    int $firstPointX,
    int $firstPointY,
    int $secondPointX,
    int $secondPointY
): bool {
    $axisX = is_int($firstPointX - $secondPointX);
    $axisY = is_int($firstPointY - $secondPointY);

    return ($axisX && $axisY);
}

function printSuccess(
    int $firstPt,
    int $secPt,
    int $thirdPt,
    int $fourthPt
): void {
    //{X, Y} to {K, J} is valid
    echo '{' . $firstPt . ', ' . $secPt . '} to {' . $thirdPt . ', ' . $fourthPt . '} is valid' . PHP_EOL;
}
