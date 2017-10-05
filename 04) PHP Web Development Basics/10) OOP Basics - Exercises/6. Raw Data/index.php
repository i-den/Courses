<?php

include './Car.php';
include './functions.php';

use Van\Classes\Car;

$carCount = intval(trim(fgets(STDIN)));
$cars = array();

for ($i = 0; $i < $carCount; $i++) {
    $carInfo = explode(' ', trim(fgets(STDIN)));

    //К'во стана тука е..
    $model = $carInfo[0];
    $engineSpeed = intval($carInfo[1]);
    $enginePower = intval($carInfo[2]);
    $cargoWeight = intval($carInfo[3]);
    $cargoType = $carInfo[4];
    $firstTirePressure = floatval($carInfo[5]);
    $firstTireAge = intval($carInfo[6]);
    $secondTirePressure = floatval($carInfo[7]);
    $secondTireAge = intval($carInfo[8]);
    $thirdTirePressure = floatval($carInfo[9]);
    $thirdTireAge = intval($carInfo[10]);
    $fourthTirePressure = floatval($carInfo[11]);
    $fourthTireAge = intval($carInfo[12]);

    $cars[] = new Car(
        $model,
        $engineSpeed,
        $enginePower,
        $cargoWeight,
        $cargoType,
        $firstTirePressure,
        $firstTireAge,
        $secondTirePressure,
        $secondTireAge,
        $thirdTirePressure,
        $thirdTireAge,
        $fourthTirePressure,
        $fourthTireAge
    );
}

$typeToDisplay = trim(fgets(STDIN));

displayAllCars($cars, $typeToDisplay);
