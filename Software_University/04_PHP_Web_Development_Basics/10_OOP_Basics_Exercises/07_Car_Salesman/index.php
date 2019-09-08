<?php

use Van\Classes\Car;
use Van\Classes\Engine;

include './Car.php';
include './functions.php';

$engineCount = intval(trim(fgets(STDIN)));

$engines = array();
$cars = array();

for ($i = 0; $i < $engineCount; $i++) {
    $engineInfo = explode(' ', trim(fgets(STDIN)));

    $model = $engineInfo[0];
    $power = intval($engineInfo[1]);

    $engine = new Engine($model, $power);

    if (count($engineInfo) > 2) {
        for ($j = 2; $j < count($engineInfo); $j++) {
            $currInfo = $engineInfo[$j];

            if (is_numeric($currInfo)) {
                $engine->setDisplacement(intval($currInfo));
            } else {
                $engine->setEfficiency($currInfo);
            }
        }
    }

    $engines[] = $engine;
}

$carCount = intval(trim(fgets(STDIN)));

for ($i = 0; $i < $carCount; $i++) {
    $carInfo = explode(' ', trim(fgets(STDIN)));

    $model = $carInfo[0];
    $engineModel = $carInfo[1];

    $engine = findEngine($engines, $engineModel);

    $car = new Car($model, $engine);

    if (count($carInfo) > 2) {
        for ($j = 2; $j < count($carInfo); $j++) {
            $currInfo = $carInfo[$j];

            if (is_numeric($currInfo)) {
                $car->setWeight(intval($currInfo));
            } else {
                $car->setColor($currInfo);
            }
        }
    }

    $cars[] = $car;
}

foreach ($cars as $car) {
    echo $car;
}
