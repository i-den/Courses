<?php

include "./Person.php";

use \Van\ClassesC\Person;

$people = array();

while (true) {
    $personInfo = explode(' ', trim(fgets(STDIN)));

    if ($personInfo[0] === 'END') {
        break;
    }

    $name = $personInfo[0];
    $age = intval($personInfo[1]);
    $occupation = $personInfo[2];

    $people[]= new Person($name, $age, $occupation);
}

usort($people, function (Person $firstPerson, Person $secondPerson) {
   return $firstPerson->getAge() > $secondPerson->getAge();
});

foreach ($people as $person) {
    echo $person . PHP_EOL;
}
