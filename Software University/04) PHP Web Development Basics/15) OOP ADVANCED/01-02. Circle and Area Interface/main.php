<?php

require_once './IArea.php';
require_once './ICircumference.php';
require_once './Circle.php';
require_once './Rectangle.php';


use Van\Classes\First\Circle;
use Van\Classes\First\Rectangle;


$myCircle = new Circle(10);
$myRectangle = new Rectangle(15, 35);

echo $myCircle;
echo $myRectangle;

