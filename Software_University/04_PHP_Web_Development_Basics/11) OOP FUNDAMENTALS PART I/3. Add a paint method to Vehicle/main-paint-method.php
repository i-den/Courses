<?php

declare(strict_types=1);

require_once './Vehicle.php';

use Van\ThirdClasses\Vehicle;

$vehicle = new Vehicle(4, 'orange');

echo $vehicle->color . PHP_EOL;

$vehicle->paint('green');

echo $vehicle->color . PHP_EOL;