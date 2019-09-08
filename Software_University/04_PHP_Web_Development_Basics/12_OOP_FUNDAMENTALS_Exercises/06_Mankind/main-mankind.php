<?php

declare(strict_types=1);

require_once './Human.php';
require_once './Student.php';
require_once './Worker.php';

use Van\Classes\Sixth\Human;
use Van\Classes\Sixth\Student;
use Van\Classes\Sixth\Worker;

$studentInfo = explode(' ', trim(fgets(STDIN)));
$studentFirstName = $studentInfo[0];
$studentLastName = $studentInfo[1];
$studentFacultyNumber = intval($studentInfo[2]);

$workerInfo = explode(' ', trim(fgets(STDIN)));
$workerFirstName = $workerInfo[0];
$workerLastName = $workerInfo[1];
$workerWeekSalary = floatval($workerInfo[2]);
$workerSalaryPerHour = intval($workerInfo[3]);

$student =  new Student($studentFirstName, $studentLastName, $studentFacultyNumber);
$worker =  new Worker($workerFirstName, $workerLastName, $workerWeekSalary, $workerSalaryPerHour);

echo $student;
echo $worker;
