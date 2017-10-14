<?php

require_once './ICar.php';
require_once './Ferrari.php';

use Van\Classes\Third\Ferrari;


$car = new Ferrari('488-Spider', 'Bat Giorgi');

echo $car;
