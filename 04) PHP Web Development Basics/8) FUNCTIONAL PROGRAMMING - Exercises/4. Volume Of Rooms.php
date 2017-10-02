<?php

$room = [
    'kithen'      => ['width'=> 3,'length'=>2, 'height' => 2.4],
    'living_room' => ['width'=> 6,'length'=>4, 'height' => 2.4],
    'bedroom'     => ['width'=> 5,'length'=>3, 'height' => 2.2],
];

$volumes = array_map(function($a) {
    return $a['width'] * $a['length'] * $a['height'];
},$room);

print_r($volumes);
