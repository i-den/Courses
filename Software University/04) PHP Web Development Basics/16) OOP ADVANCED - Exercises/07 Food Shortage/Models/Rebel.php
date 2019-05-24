<?php


namespace Models;


class Rebel extends Person
{
    private $group;
    private $food = 0;

    public function __construct(array $rebelArgs)
    {
        $name = $rebelArgs[0];
        $age = intval($rebelArgs[1]);
        $group = $rebelArgs[2];

        $this->setGroup($group);
        parent::__construct($name, $age);
    }

    public function buyFood()
    {
        $this->food += 5;
    }

    public function getFood(): int
    {
        return $this->food;
    }

    public function getGroup()
    {
        return $this->group;
    }

    public function setGroup($group)
    {
        $this->group = $group;
    }
}