<?php
include "./Car.php";

use Van\ClassesC\Car;

$input = explode(" ", fgets(STDIN));

$speed = floatval($input[0]);
$fuel = floatval($input[1]);
$fuelEconomy = floatval($input[2]);

$car = new Car($speed, $fuel, $fuelEconomy);

while (true) {
    $command = explode(' ', trim(fgets(STDIN)));

    if  ($command[0] === 'END') {
        break;
    }

    switch ($command[0]) {
        case 'Travel':
            $car->travel(floatval($command[1]));
            break;
        case 'Refuel':
            $car->refuel(floatval($command[1]));
            break;
        case 'Distance':
            $car->printDistance();
            break;
        case 'Time':
            $car->printTime();
            break;
        case 'Fuel':
            $car->printFuel();
            break;
    }
}
