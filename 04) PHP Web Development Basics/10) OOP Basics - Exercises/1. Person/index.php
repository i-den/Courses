<?php

include './Person.php';

$name = trim(fgets(STDIN));
$age = intval(trim(fgets(STDIN)));

$person = new Person($name, $age);

echo $person->getName() . ' ' . $person->getAge() . PHP_EOL;