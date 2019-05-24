<?php


namespace Models;


abstract class Person implements IBuyer
{
    protected $name;
    protected $age;

    public function __construct(string $name, int $age)
    {
        $this->setName($name)
            ->setAge($age);
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setName($name): Person
    {
        $this->name = $name;
        return $this;
    }

    public function getAge(): int
    {
        return $this->age;
    }

    public function setAge($age): Person
    {
        $this->age = $age;
        return $this;
    }
}