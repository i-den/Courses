<?php

use Van\Classes\Third\DesktopComputer;
use Van\Classes\Third\Laptop;
use Van\Classes\Third\Notebook;
use Van\Classes\Third\Phone;
use Van\Classes\Third\Tablet;

require_once './IKeyboard.php';
require_once './IMouse.php';
require_once './ITouchScreen.php';
require_once './Computer.php';
require_once './DesktopComputer.php';
require_once './Laptop.php';
require_once './Mobile.php';
require_once './Tablet.php';
require_once './Phone.php';
require_once './Notebook.php';


$desktopCompooter = new DesktopComputer('Da CPU', 512, true);

$firstLaptop = new Laptop('Porcesorr', 4098, 58);
$secondLaptop = new Laptop('Porcesorr 2x', 2046, 77);

$tablet = new Tablet('GeiTel', false, 100, '1920x1280');

$firstPhone = new Phone(1);
$firstPhone = new Phone(33);
$firstPhone = new Phone(7);

$notebook = new Notebook('GeiTel', true, 59);

$notebook->clickFinger();

