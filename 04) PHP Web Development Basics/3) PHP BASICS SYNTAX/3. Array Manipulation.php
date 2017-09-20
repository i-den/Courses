<?php

$names = array('Joe', 'Peter', 'Richard', 'John');

array_splice($names, 1, 1);

var_dump($names);

array_splice($names, 1, 0, 'George');

var_dump($names);
