<?php

$fruits = array(
    'orange',
    'banana',
    'apple',
    'kiwi'
);

$a = array_shift($fruits);

echo $a;
var_dump($fruits);

$b = array_unshift($fruits, 'orange');

var_dump($b);
var_dump($fruits);
