<?php

use Van\Classes\First\Citizen;

require_once './IPerson.php';
require_once './Citizen.php';

$myCitizen = new Citizen('Peter', 25);
echo $myCitizen;