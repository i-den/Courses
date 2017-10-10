<?php

declare(strict_types=1);

require_once './Vehicle.php';
require_once './Car.php';

use Van\FifthClasses\Vehicle;
use Van\FifthClasses\Car;

$car = new Car(4, 'Red', 'Audi', 'A4', 2004);

print_r($car);

$car->paint('Green');

print_r($car);
