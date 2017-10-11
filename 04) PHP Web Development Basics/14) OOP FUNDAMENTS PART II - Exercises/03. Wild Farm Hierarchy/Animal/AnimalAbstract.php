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

    public function getType(): string
    {
        return substr(
            static::class,
            strrpos(static::class, '\\') + 1
        );
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

    /**
     * @return Food[]
     */
    protected function getFoodEaten(): array
    {
        return $this->foodEaten;
    }

    protected function getTotalAmountOfFoodEaten(): int
    {
        $totalFood = 0;

        foreach ($this->getFoodEaten() as $currentFood) {
            $totalFood += $currentFood->getQuantity();
        }

        return $totalFood;
    }

    public function eat(Food $food): void
    {
        $this->foodEaten[] = $food;
    }
}
