<?php

$letters = array(
    'b', 'a,', 'd', 'c', 'z', 'y'
);

asort($letters);

var_dump($letters);

for ($i = 0; $i < count($letters); $i++) {
    echo $letters[$i] . '<br />';
}