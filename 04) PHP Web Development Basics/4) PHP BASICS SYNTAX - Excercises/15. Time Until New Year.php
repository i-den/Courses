<?php

$input = trim(fgets(STDIN));

$startingDate = date_create_from_format('d-m-Y H:i:s', $input, new DateTimeZone('Europe/Sofia'));
$dateNewYear = intval($startingDate->format('Y')) + 1;
$endDate = new DateTime("$dateNewYear-1-1");
$endDate->modify('-1 second');

$startingDateTimeStamp = date_timestamp_get($startingDate);
$endingDateTimeStamp = date_timestamp_get($endDate);

$diff = date_diff($startingDate, $endDate);
$totalDays = intval($diff->format('%a'));
$totalHours = intval($diff->format('%H'));
$totalMinutes = intval($diff->format('%I'));
$totalSeconds = intval($diff->format('%S'));


$diffTime = $endingDateTimeStamp - $startingDateTimeStamp;

$hours = floor($diffTime / 3600);
$minutes = ($hours * 60);
$seconds = ($minutes * 60);

$minutes = number_format($minutes, 0, '', ' ');
$seconds = number_format($seconds, 0, '', ' ');

echo "Hours until New Year : $hours \n";
echo "Minutes until New Year : $minutes \n";
echo "Seconds until New Year : $seconds \n";
echo "Days:Hours:Minutes:Seconds $totalDays:$totalHours:$totalMinutes:$totalSeconds\n";


//var_dump($startingDateTimeStamp);
//var_dump($endingDateTimeStamp);
//var_dump($dateNewYear);
//var_dump($endDate);
//var_dump($startingDate);

//var_dump($diff);
//var_dump($totalDays);
//var_dump($totalHours);
//var_dump($totalMinutes);
//var_dump($totalSeconds);