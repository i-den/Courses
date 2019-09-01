<?php

spl_autoload_register(function($class) {
   $classFile = $class . '.php';
   require_once $classFile;
});

use Commands\CreateCommand;
use Commands\DetainCommand;
use Commands\ListCommand;
use Core\City;

$city = new City('Plovdiv');

$takeInput = new CreateCommand($city);
$listCitizen = new ListCommand($city);

$takeInput->execute();
$listCitizen->execute();