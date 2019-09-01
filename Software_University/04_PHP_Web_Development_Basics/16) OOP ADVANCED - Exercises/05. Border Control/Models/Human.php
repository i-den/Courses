<?php


namespace Models;


class Human extends Person
{
    private $name;
    private $age;

    public function __construct(string $id, string $name, int $age)
    {
        $this->setName($name)
            ->setAge($age);
        parent::__construct($id);
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setName($name): Human
    {
        $this->name = $name;
        return $this;
    }

    public function getAge(): int
    {
        return $this->age;
    }

    public function setAge($age): Human
    {
        $this->age = $age;
        return $this;
    }
}