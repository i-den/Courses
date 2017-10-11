<?php

declare(strict_types=1);

require_once './PersonInterface.php';
require_once './Person.php';
require_once './Father.php';
require_once './Son.php';
require_once './GrandSon.php';
require_once './Generation.php';

use Family\Father;
use Family\Son;
use Family\GrandSon;
use Generation\Generation;

$firstGen = new Generation();

$james = new Father(
    'James Strong',
    DateTime::createFromFormat('Y-m-d', '1873-01-01'),
    DateTime::createFromFormat('Y-m-d', '1923-01-01')
);

$peter = new Son(
    'Peter Strong',
    DateTime::createFromFormat('Y-m-d', '1894-01-01'),
    DateTime::createFromFormat('Y-m-d', '1928-01-01')
);

$andrew = new Son(
    'Andrew Strong',
    DateTime::createFromFormat('Y-m-d', '1899-01-01'),
    DateTime::createFromFormat('Y-m-d', '1970-01-01')
);

$jackson = new GrandSon(
    'Jackson Strong',
    DateTime::createFromFormat('Y-m-d', '1927-01-01'),
    DateTime::createFromFormat('Y-m-d', '1972-01-01')
);

$martin = new GrandSon(
    'Martin Strong',
    DateTime::createFromFormat('Y-m-d', '1927-01-01'),
    DateTime::createFromFormat('Y-m-d', '1967-01-01')
);

$gregory = new GrandSon(
    'Gregory Strong',
    DateTime::createFromFormat('Y-m-d', '1931-01-01'),
    DateTime::createFromFormat('Y-m-d', '2000-01-01')
);

$firstGen->setFather($james);
$firstGen->addSon($peter);
$firstGen->addSon($andrew);
$firstGen->addGrandSon($jackson);
$firstGen->addGrandSon($martin);
$firstGen->addGrandSon($gregory);

$sonsAvgTimeSpan = Generation::getAverageSonsTimeSpan($firstGen->getSons());
$grandSonsAvgTimeSpan = Generation::getAverageSonsTimeSpan($firstGen->getGrandSons());

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table border="1" align="center" style="text-align: center">
    <thead>
    <tr>
        <th>Person:</th>
        <th>Name:</th>
        <th>Time Lived:</th>
    </tr>
    </thead>
    <tbody>
    <div>
        <tr>
            <td>Father:</td>
            <td><?= $firstGen->getFather()->getName() ?></td>
            <td><?= $firstGen->getFather()->getTimeLived()->format('%y') ?></td>
        </tr>
    </div>
    <div>
        <?php
        foreach ($firstGen->getSons() as $son): ?>
            <tr>
                <td>Son:</td>
                <td><?= $son->getName() ?></td>
                <td><?= $son->getTimeLived()->format('%y'); ?></td>
            </tr>
        <?php endforeach ?>
        <tr>
            <td>Avg LifeSpan: <?= Generation::getAverageSonsTimeSpan($firstGen->getSons()); ?></td>
        </tr>
    </div>
    <div>
        <?php foreach ($firstGen->getGrandSons() as $grandSon): ?>
            <tr>
                <td>Grandson:</td>
                <td><?= $grandSon->getName() ?></td>
                <td><?= $grandSon->getTimeLived()->format('%y'); ?></td>
            </tr>
        <?php endforeach; ?>
        <tr>
            <td>Avg LifeSpan: <?= Generation::getAverageSonsTimeSpan($firstGen->getGrandSons()); ?></td>
        </tr>
    </div>
    </tbody>
</table>
</body>
</html>