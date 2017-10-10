<?php

namespace Van\SeventhClasses;


class Vehicle
{
    /** @var  int */
    private $numberDoors;

    /** @var  string */
    protected $color;

    public function __construct(int $numberDoors, string $color)
    {
        $this->setNumberDoors($numberDoors);
        $this->setColor($color);
    }

    public function __get($property)
    {
        if ($this->{$property}) {
            return $this->{$property};
        }

        return 'property doesn\'t exist';
    }

    public function paint(string $paint)
    {
        $this->setColor($paint);
    }

    /**
     * @return int
     */
    public function getNumberDoors(): int
    {
        return $this->numberDoors;
    }

    /**
     * @param int $numberDoors
     */
    private function setNumberDoors(int $numberDoors)
    {
        $this->numberDoors = $numberDoors;
    }

    /**
     * @return string
     */
    public function getColor(): string
    {
        return $this->color;
    }

    /**
     * @param string $color
     */
    public function setColor(string $color)
    {
        $this->color = $color;
    }
}
