<?php

declare(strict_types=1);

require_once './Vehicle.php';
require_once './Car.php';

use Van\SixthClasses\Vehicle;
use Van\SixthClasses\Car;

$car = new Car(4, 'Red', 'Audi', 'A4', 2016);

print_r($car);

$car->paint('Green');

print_r($car);
