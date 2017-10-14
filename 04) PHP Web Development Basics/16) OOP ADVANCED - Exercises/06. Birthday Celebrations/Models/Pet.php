<?php


namespace Models;


class Pet implements IBirthable
{
    private $name;

    private $birthday;

    public function __construct(array $petArgs)
    {
        $name = $petArgs[0];
        $birthday = $petArgs[1];

        $this->setName($name)
            ->setBirthday($birthday);
    }

    public function getName()
    {
        return $this->name;
    }

    public function setName($name): Pet
    {
        $this->name = $name;
        return $this;
    }

    public function getBirthday(): string
    {
        return $this->birthday;
    }

    public function setBirthday($birthday): Pet
    {
        $this->birthday = $birthday;
        return $this;
    }
}