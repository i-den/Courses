<?php

declare(strict_types=1);

include_once './Vehicle.php';

use Van\FirstClasses\Vehicle;

$vehicle = new Vehicle(2, 'orange');

print_r($vehicle);
