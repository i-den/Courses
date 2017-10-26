<?php
/**
 * File initializing the application and running it
 */

use Core\Database\FakeDoctrine;
use Service\Application;

$database       = new FAkeDoctrine();
$application    = new Application($database);

$application->start();