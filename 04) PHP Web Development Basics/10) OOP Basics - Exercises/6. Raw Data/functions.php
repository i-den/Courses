<?php

use Van\Classes\Car;

/**
 * Filters the and then displays the $cars array
 *
 * @param array $cars
 * @param string $typeToDisplay
 * @param int $extraProperty
 */
function displayAllCars(array $cars, string $typeToDisplay, int $extraProperty = 0)
{
    $carsToDisplay = array();

    switch ($typeToDisplay) {
        case 'fragile':
            $extraProperty = 1;
            foreach ($cars as $car) {
                if ($car->isCargoType($typeToDisplay) && $car->hasTirePressureOfLessThan($extraProperty)) {
                    $carsToDisplay[] = $car->getModel();
                }
            }
            break;
        case 'flamable':
            $extraProperty = 250;
            foreach ($cars as $car) {
                if ($car->isCargoType($typeToDisplay) && $car->hasEnginePowerOfMoreThan($extraProperty)) {
                    $carsToDisplay[] = $car->getModel();
                }
            }
            break;
    }

    echo implode(PHP_EOL, $carsToDisplay);
}