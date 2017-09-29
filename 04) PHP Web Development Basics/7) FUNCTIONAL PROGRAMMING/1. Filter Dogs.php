<?php

$animals = [
    ['name' => 'Waffles', 'type' => 'dog', 'age' => 12],
    ['name' => 'Fluffy', 'type' => 'cat', 'age' => 14],
    ['name' => 'Spelunky', 'type' => 'dog', 'age' => 4],
    ['name' => 'Hank', 'type' => 'dog', 'age' => 11],
];

$filterDogs = function (array $array, int $age, string $type)
{
    $dogsToReturn = array();

    $filter = function (array $array, callable $function) {
        $result = array();

        for ($i = 0; $i < count($array); $i++) {
            if ($function($array[$i])) {
                $result[] = $array[$i];
            }
        }

        return $result;
    };

    $youngDogs = function (array $animals, callable $filter, int $age = 9) {
        return $filter($animals, function ($animal) use ($age) {
            return ($animal['type'] === 'dog'
                && $animal['age'] >= $age);
        });
    };

    $oldDogs = function (array $animals, callable $filter, int $age = 9) {
        return $filter($animals, function ($animal) use ($age) {
            return ($animal['type'] === 'dog'
                && $animal['age'] <= $age);
        });
    };

    switch ($type) {
        case 'young':
            $dogsToReturn = $youngDogs($array, $filter, $age);
            break;
        case 'old':
            $dogsToReturn = $oldDogs($array, $filter, $age);
            break;
        default:
            die('Wrong mate');
            break;
    }

    return $dogsToReturn;
};