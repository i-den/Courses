<?php

declare(strict_types=1);

require_once './Person.php';
require_once './Child.php';

use Van\Classes\Fourth\Child;

$child = new Child('Asdd', 15);

print_r($child);
