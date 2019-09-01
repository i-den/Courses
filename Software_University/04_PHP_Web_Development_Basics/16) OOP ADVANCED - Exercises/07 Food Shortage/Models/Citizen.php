<?php


namespace Models;


class Citizen extends Person
{

    private $id;
    private $birthday;
    private $food = 0;

    public function __construct(array $citizenArgs)
    {
        $name = $citizenArgs[0];
        $age = intval($citizenArgs[1]);
        $id = $citizenArgs[2];
        $birthday = $citizenArgs[3];

        $this->setId($id)
            ->setBirthday($birthday);
        parent::__construct($name, $age);
    }

    public function getId(): int
    {
        return $this->id;
    }

    public function setId($id): Citizen
    {
        $this->id = $id;
        return $this;
    }

    public function getBirthday(): string
    {
        return $this->birthday;
    }

    public function setBirthday($birthday): Citizen
    {
        $this->birthday = $birthday;
        return $this;
    }

    public function buyFood()
    {
        $this->food += 10;
    }

    public function getFood(): int
    {
        return $this->food;
    }
}