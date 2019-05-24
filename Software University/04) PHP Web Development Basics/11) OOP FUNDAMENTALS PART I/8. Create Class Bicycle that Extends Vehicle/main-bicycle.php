<?php

declare(strict_types=1);

require_once './Vehicle.php';
require_once './Bicycle.php';

use Van\EightClass\Bicycle;

$firstBike = new Bicycle('Red', 'BMX', 'zZz', 2000);
$secondBike = new Bicycle('Blue', 'SPRINT', 'XxX', 2001);

$firstBike->ride();
$secondBike->stop();

echo $firstBike;
echo $secondBike;
