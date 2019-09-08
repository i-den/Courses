<?php


namespace Food;


abstract class Food
{
    /** @var  int */
    protected $quantity;

    public function __construct(int $quantity)
    {
        $this->setQuantity($quantity);
    }

    public function getQuantity(): int
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
