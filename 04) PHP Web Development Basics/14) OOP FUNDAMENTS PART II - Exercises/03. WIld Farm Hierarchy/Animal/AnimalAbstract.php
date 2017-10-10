<?php

namespace Animals;


use Food\Food;

abstract class AnimalAbstract implements AnimalInterface
{
    protected $name;

    protected $type;

    protected $weight;

    /**
     * @var Food[]
     */
    protected $foodEaten = array();

    protected function __construct(
        string $name,
        string $type,
        string $weight
    )
    {
        $this->setName($name)
            ->setType($type)
            ->setWeight(floatval($weight));
    }

    protected function getName()
    {
        return $this->name;
    }

    protected function setName($name): AnimalAbstract
    {
        $this->name = $name;
        return $this;
    }

    protected function getType()
    {
        return $this->type;
    }

    protected function setType($type): AnimalAbstract
    {
        $this->type = $type;
        return $this;
    }

    protected function getWeight()
    {
        return $this->weight;
    }

    protected function setWeight($weight): AnimalAbstract
    {
        $this->weight = $weight;
        return $this;
    }

    protected function getFoodEaten()
    {
        return $this->foodEaten;
    }

    protected function setFoodEaten($foodEaten): AnimalAbstract
    {
        $this->foodEaten = $foodEaten;
        return $this;
    }

}