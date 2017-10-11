<?php


namespace Animals;


use Food\Food;

class Cat extends FelineAbstract
{
    private $breed;

    public function __construct($name, $type, $weight, $livingRegion, $breed)
    {
        $this->setBreed($breed);
        parent::__construct($name, $type, $weight, $livingRegion);

    }

    public function __toString()
    {
        $animalOutput = $this->getType() . '[';
        $animalOutput .= $this->getName() . ', ';
        $animalOutput .= $this->getBreed() . ', ';
        $animalOutput .= $this->getWeight() . ', ';
        $animalOutput .= $this->getLivingRegion() . ', ';
        $animalOutput .= $this->getTotalAmountOfFoodEaten() . ']';

        return $animalOutput;
    }

    public function makeSound(): void
    {
        echo 'Meowwww' . PHP_EOL;
    }

    public function eat(Food $food): void
    {
        parent::eat($food);
    }

    private function getBreed(): string
    {
        return $this->breed;
    }

    private function setBreed(string $breed)
    {
        $this->breed = $breed;
    }
}