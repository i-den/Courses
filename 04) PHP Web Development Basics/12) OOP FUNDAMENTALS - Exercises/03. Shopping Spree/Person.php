<?php

namespace Van\Classes\Third;


use Van\Classes\Third\Product;

class Person
{
    /** @var  string */
    private $name;

    /** @var  float */
    private $money;

    /** @var  Product[] */
    private $products = array();

    public function __construct(string $name, float $money)
    {
        $this->setName($name)
            ->setMoney($money);
    }

    public function setName(string $name): Person
    {
        if (!isset($name)) {
            exit('Name cannot be empty');
        }

        $this->name = $name;

        return $this;
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setMoney(float $money): Person
    {
        if ($money < 0) {
            exit('Money cannot be negative');
        }

        $this->money = $money;

        return $this;
    }

    public function addProduct(Product $product)
    {
        $this->products[] = $product;
    }

    public function canBuy(Product $product): bool
    {
        return $this->money - $product->getCost() >= 0;
    }

    public function buyProduct(Product $product)
    {
        $this->money -= $product->getCost();
        $this->products[] = $product;
    }

    public function __toString()
    {
        $personOutput = $this->name;

        $personOutput .= empty($this->products)
            ? ' - Nothing bought'
            : ' - ' . implode(', ', $this->products) . PHP_EOL;

        return $personOutput;
    }
}
