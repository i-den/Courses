<?php

require_once './Animal/AnimalInterface.php';
require_once './Animal/AnimalAbstract.php';
require_once './Animal/MammalAbstract.php';
require_once './Animal/FelineAbstract.php';
require_once './Animal/Mouse.php';
require_once './Animal/Zebra.php';
require_once './Animal/Cat.php';
require_once './Animal/Tiger.php';
require_once './Food/Food.php';
require_once './Food/Meat.php';
require_once './Food/Vegetable.php';

use Animals\Mouse;
use Animals\Zebra;
use Animals\Tiger;
use Animals\Cat;
use Food\Meat;
use Food\Vegetable;

$animals = array();

while (true) {
    $animalInput = explode(' ', trim(fgets(STDIN)));

    if ($animalInput[0] === 'End') {
        break;
    }

    $foodInfo = explode(' ', trim(fgets(STDIN)));

    $animalClass = 'Animals\\' . $animalInput[0];
    $animal = null;
    if ($animalInput[0] === 'Cat') {
        $animal = new $animalClass($animalInput[1], $animalInput[0] ,$animalInput[2], $animalInput[3] ,$animalInput[4]);
    } else {
        $animal = new $animalClass($animalInput[1], $animalInput[0] ,$animalInput[2], $animalInput[3]);
    }
    $foodClass = 'Food\\' . $foodInfo[0];
    $foodQuantity = intval($foodInfo[1]);
    $food = new $foodClass($foodQuantity);
    try {
        $animal->makeSound();
        $animal->eat($food);
    } catch (\Exception $e) {
        echo $e->getMessage() . PHP_EOL;
    }

    $animals[] = $animal;
}

foreach ($animals as $animal) {
    echo $animal;
}
