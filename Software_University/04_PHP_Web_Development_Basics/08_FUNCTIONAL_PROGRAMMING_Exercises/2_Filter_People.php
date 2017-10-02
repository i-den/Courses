<?php

$people = [
['name'=> 'John'  , 'height'=> 1.65],
['name'=> 'Peter' , 'height'=> 1.85],
['name'=> 'Silvia', 'height'=> 1.69],
['name'=> 'Martin', 'height'=> 1.82]
];

$filteredPeople = array_filter($people, function($person) {
    return $person['height'] > 1.80;
});

print_r($filteredPeople);
