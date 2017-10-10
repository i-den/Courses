<?php

declare(strict_types=1);

require_once './Vehicle.php';

use Van\SecondClasses\Vehicle;

$vehicle = new Vehicle(4, 'orange');

echo $vehicle->numberDoors;
