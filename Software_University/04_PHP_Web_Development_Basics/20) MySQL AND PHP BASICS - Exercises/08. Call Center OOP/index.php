<?php

declare(strict_types=1);

use Config\Connection;
use Core\CallCenter;

require_once './Core/autoload.php';

$database = new Connection();
$callCenter = new CallCenter($database);
$callCenter->startWork();

