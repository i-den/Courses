<?php

declare(strict_types=1);

require_once './Vehicle.php';
require_once './Car.php';

use Van\FourthClasses\Vehicle;
use Van\FourthClasses\Car;

$car = new Car(4, 'Red', 'Audi', 'A4', 2004);

print_r($car);
