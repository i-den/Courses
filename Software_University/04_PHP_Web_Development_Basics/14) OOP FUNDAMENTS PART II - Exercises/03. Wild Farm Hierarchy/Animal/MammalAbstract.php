<?php


namespace Animals;


use Food\Food;

abstract class MammalAbstract extends AnimalAbstract
{
    protected $livingRegion;

    public function __construct(
        string $name,
        string $type,
        string $weight,
        string $livingRegion)
    {
        $this->setLivingRegion($livingRegion);
        parent::__construct($name, $type, $weight);
    }

    public function __toString()
    {
        $animalOutput = $this->getType() . '[';
        $animalOutput .= $this->getName() . ', ';
        $animalOutput .= $this->getWeight() . ', ';
        $animalOutput .= $this->getLivingRegion() . ', ';
        $animalOutput .= $this->getTotalAmountOfFoodEaten() . ']';
        
        return $animalOutput;
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
