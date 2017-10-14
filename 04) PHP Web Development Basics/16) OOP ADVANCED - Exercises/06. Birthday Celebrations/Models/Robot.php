<?php


namespace Models;


class Robot extends Person
{
    private $name;

    public function __construct(array $robotArgs)
    {
        $name = $robotArgs[0];
        $id = $robotArgs[1];

        $this->setName($name);
        parent::__construct($id);
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setName(string $name): Robot
    {
        $this->name = $name;
        return $this;
    }
}