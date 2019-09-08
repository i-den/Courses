<?php


namespace Models;


class Citizen extends Person implements IBirthable
{
    private $name;
    private $age;
    private $birthday;

    public function __construct(array $humanArgs)
    {
        $name = $humanArgs[0];
        $age = intval($humanArgs[1]);
        $id = $humanArgs[2];
        $birthday = $humanArgs[3];

        $this->setName($name)
            ->setAge($age)
            ->setBirthday($birthday);
        parent::__construct($id);
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setName($name): Citizen
    {
        $this->name = $name;
        return $this;
    }

    public function getAge(): int
    {
        return $this->age;
    }

    public function setAge($age): Citizen
    {
        $this->age = $age;
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
}