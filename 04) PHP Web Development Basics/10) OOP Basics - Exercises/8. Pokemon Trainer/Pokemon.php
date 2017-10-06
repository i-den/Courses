<?php

namespace Van\Classes;

class Pokemon
{
    private $name;

    private $element;

    private $health;

    public function __construct(string $name, string $element, int $health)
    {
        $this->name = $name;
        $this->element = $element;
        $this->health = $health;
    }

    public function getElement(): string
    {
        return $this->element;
    }

    public function loseHealth(int $healthTaken)
    {
        $this->health -= $healthTaken;
    }

    public function getHealth(): int
    {
        return $this->health;
    }
}
