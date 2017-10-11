<?php


namespace Animals;


use Food\Food;

class Tiger extends FelineAbstract
{
    const ALLOWED_FOOD = array('Meat');

    public function makeSound(): void
    {
        echo 'ROAAR!!!' . PHP_EOL;
    }

    public function eat(Food $food): void
    {
        if (!in_array($food->getType(), self::ALLOWED_FOOD)) {
            throw new \Exception($this->getType() . ' are not eating that type of food!' . PHP_EOL);
        }

        parent::eat($food);
    }
}