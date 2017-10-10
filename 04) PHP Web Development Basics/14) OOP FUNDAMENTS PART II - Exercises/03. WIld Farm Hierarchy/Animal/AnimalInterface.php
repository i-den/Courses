<?php

namespace Animals;

use Food\Food;

interface AnimalInterface
{
    public function makeSound(): void;

    public function eat(Food $food): void;
}