<?php


namespace Animals;


use Food\Food;

class Mouse extends MammalAbstract
{
    const ALLOWED_FOOD = array('Vegetable');

    public function makeSound(): void
    {
        echo 'SQUEEEAAAK!' . PHP_EOL;
    }

    public function eat(Food $food): void
    {
        if (!in_array($food->getType(), self::ALLOWED_FOOD)) {
            throw new \Exception($this->getType() . ' are not eating that type of food!' . PHP_EOL);
        }

        parent::eat($food);
    }
}