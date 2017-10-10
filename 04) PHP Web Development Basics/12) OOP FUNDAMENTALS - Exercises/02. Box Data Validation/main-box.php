<?php

require_once './Box.php';

use Van\Classes\Second\Box;


$length = floatval(trim(fgets(STDIN)));
$width = floatval(trim(fgets(STDIN)));
$height = floatval(trim(fgets(STDIN)));

$box = new Box($length, $width, $height);

echo 'Surface Area - ' . $box->getSurfaceArea() . PHP_EOL;
echo 'Lateral Surface Area - ' . $box->getLateralSurfaceArea() . PHP_EOL;
echo 'Volume - ' . $box->getVolume() . PHP_EOL;
