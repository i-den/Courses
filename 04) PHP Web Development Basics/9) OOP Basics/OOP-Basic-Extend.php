<?php

include './Car-Extend.php';

use \Van\Classes\Car;

$carToPrint = new Car('Ferarri', 'Enzo', 'G-250', 2, 350);
$carToPrint->setYear(2013);

print_r($carToPrint);
