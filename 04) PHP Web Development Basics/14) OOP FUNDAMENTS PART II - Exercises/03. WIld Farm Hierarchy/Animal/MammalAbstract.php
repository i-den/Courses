<?php


namespace Animals;


use Food\Food;

abstract class MammalAbstract extends AnimalAbstract
{
    private $livingRegion;

    protected function __construct($name, $type, $weight, $foodEaten)
    {
        $this->setFoodEaten($foodEaten);
        parent::__construct($name, $type, $weight, $foodEaten);
    }

    protected function getLivingRegion(): string
    {
        return $this->livingRegion;
    }

    protected function setLivingRegion(string $livingRegion): MammalAbstract
    {
        $this->livingRegion = $livingRegion;
        return $this;
    }
}