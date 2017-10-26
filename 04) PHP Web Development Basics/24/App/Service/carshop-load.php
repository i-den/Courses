<?php


use Core\Database\Doctreen;
use Service\CarShop;

$database   = new Doctreen();
$carShop    = new CarShop($database);

$carShop->serve();
