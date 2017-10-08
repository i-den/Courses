<?php

declare(strict_types=1);

require_once './Vehicle.php';
require_once './Car.php';

use Van\SeventhClasses\Car;

$car = new Car(4, 'Red', 'Audi', 'A4', 2016);

echo $car->setNumberDoors(5);
