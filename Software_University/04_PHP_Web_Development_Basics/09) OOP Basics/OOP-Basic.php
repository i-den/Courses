<?php

include './Car.php';

use \Van\Classes\Car;

$cars = array();

for ($i = 0; $i < 4; $i++) {
    $carInputInfo = explode(' ', trim(fgets(STDIN)));

    $brand = $carInputInfo[0];
    $model = $carInputInfo[1];
    $year = $carInputInfo[2];

    $currCar = new Car($brand, $model);
    $currCar->setYear($year);

    $cars[] = $currCar;
}

usort($cars, function (Car $firstCar, Car $secondCar) {
    $brandComparison = $firstCar->getBrand() <=> $secondCar->getBrand();
    if ($brandComparison === 0) {
        $modelComparison = $firstCar->getModel() <=> $secondCar->getModel();
        if ($modelComparison === 0) {
            $yearComparison = $firstCar->getYear() <=> $secondCar->getYear();
            return $yearComparison;
        }
        return $modelComparison;
    }
    return $brandComparison;
});

echo PHP_EOL;
foreach ($cars as $car) {
    $car->printStats();
}
