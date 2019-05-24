<?php

namespace Van\Classes\Fourth;


class Person
{
    /** @var  string */
    protected $name;

    /** @var  int */
    protected $age;

    public function __construct(string $name, int $age)
    {
        $this->setName($name)
            ->setAge($age);
    }

    protected function getName(): string
    {
        return $this->name;
    }

    protected function setName(string $name): Person
    {
        if (strlen($name) <= 3) {
            throw new \Exception('Name\'s length should not be less than 3 symbols');
        }

        $this->name = $name;

        return $this;
    }

    protected function getAge(): int
    {
        return $this->age;
    }

    protected function setAge(int $age): Person
    {
        if ($age <= 0) {
            throw new \Exception('Age must be positive!');
        }

        $this->age = $age;

        return $this;
    }
}
