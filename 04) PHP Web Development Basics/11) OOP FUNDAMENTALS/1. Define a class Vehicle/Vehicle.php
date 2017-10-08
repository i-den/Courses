<?php

namespace Van\FirstClasses;


class Vehicle
{
    /** @var  int */
    private $numberDoors;

    /** @var  string */
    private $color;

    public function __construct(int $numberDoors, string $color)
    {
     $this->numberDoors = $numberDoors;
     $this->color = $color;
    }
}
