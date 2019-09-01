<?php

include './Car.php';

use Van\Classes\Car;

$carsCount = intval(trim(fgets(STDIN)));
$cars = array();

for ($i = 0; $i < $carsCount; $i++) {
    $carInfo = explode(' ', trim(fgets(STDIN)));

    $model = $carInfo[0];
    $fuelAmount = floatval($carInfo[1]);
    $fuelPerKm = floatval($carInfo[2]);

    $cars[] = new Car($model, $fuelAmount, $fuelPerKm);
}

while (true) {
    $input = explode(' ', trim(fgets(STDIN)));

    if ($input[0] === 'End') {
        break;
    }

    $model = $input[1];
    $distanceToTravel = intval($input[2]);

    $car = array_values(array_filter(
        $cars,
        function (Car $car) use ($model) {
            return $car->getModel() === $model;
        }
    ))[0];

    $fuelToExhaust = round($car->getFuelPerKm() * $distanceToTravel, 2, PHP_ROUND_HALF_UP);

    if ($car->hasFuelToDrive($fuelToExhaust)) {
        $car->drive($fuelToExhaust, $distanceToTravel);
    } else {
        echo 'Insufficient fuel for the drive' . PHP_EOL;
    }
}

foreach ($cars as $car) {
    $car->printStats();
}
