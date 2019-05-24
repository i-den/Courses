<?php

include "./Person.php";
include "./Family.php";

use Van\Classes\Family;
use Van\Classes\Person;

$family = new Family();

$familyMembersCount = intval(trim(fgets(STDIN)));

for ($i = 0; $i < $familyMembersCount; $i++) {
    $familyInfo = explode(' ', trim(fgets(STDIN)));

    $name = $familyInfo[0];
    $age = intval($familyInfo[1]);

    $member = new Person($name, $age);
    $family->addMember($member);
}

$oldestMember = $family->getOldestMember();

echo $oldestMember->getName() . ' ' . $oldestMember->getAge();