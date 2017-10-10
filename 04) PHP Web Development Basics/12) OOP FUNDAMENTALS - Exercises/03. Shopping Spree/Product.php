<?php

namespace Van\Classes\Third;


class Product
{
    /** @var  string */
    private $name;

    /** @var  float */
    private $cost;

    public function __construct(string $name, float $cost)
    {
        $this->setName($name)
            ->setCost($cost);
    }

    public function setName(string $name): Product
    {
        $this->name = $name;

        return $this;
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setCost(float $cost)
    {
        $this->cost = $cost;
    }

    public function getCost(): float
    {
        return $this->cost;
    }

    public function __toString()
    {
        return $this->name;
    }
}
