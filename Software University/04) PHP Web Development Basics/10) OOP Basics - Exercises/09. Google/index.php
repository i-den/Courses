<?php

require_once './Person.php';
require_once './functions.php';

$people = getPeople();

$name = trim(fgets(STDIN));

echo personExists($people, $name);
