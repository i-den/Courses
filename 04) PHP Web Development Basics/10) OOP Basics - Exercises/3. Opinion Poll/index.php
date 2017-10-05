<?php

include './Person.php';

$personCount = intval(trim(fgets(STDIN)));
$people = array();

for ($i = 0; $i < $personCount; $i++) {

    $input = explode(' ', trim(fgets(STDIN)));

    $name = $input[0];
    $age = intval($input[1]);

    $people[] = new Person($name, $age);
}

usort($people, function ($firstPerson, $secondPerson) {
   return strcmp($firstPerson->getName(), $secondPerson->getName());
});

foreach ($people as $person) {
    $person->printInfo();
}
