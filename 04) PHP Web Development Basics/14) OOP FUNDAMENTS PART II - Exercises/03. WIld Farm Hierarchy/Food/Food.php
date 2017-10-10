<?php


namespace Food;


abstract class Food
{
    /** @var  int */
    protected $quantity;

    protected function __construct(int $quantity)
    {
        $this->setQuantity($quantity);
    }

    protected function getQuantity(): int
    {
        return $this->quantity;
    }

    protected function setQuantity(int $quantity): Food
    {
        $this->quantity = $quantity;
        return $this;
    }

    public function getType(): string
    {
        return substr(
            static::class,
            strrpos(static::class, '\\') + 1
        );
    }
}