<?php

include "./DateModifier.php";

use Van\ClassesC\DateModifier;

$startDay = trim(fgets(STDIN));
$endDay = trim(fgets(STDIN));

$dateToPrint = new DateModifier($startDay, $endDay);

echo $dateToPrint;

