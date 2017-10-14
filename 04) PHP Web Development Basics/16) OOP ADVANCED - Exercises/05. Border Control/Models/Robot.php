<?php


namespace Models;


class Robot extends Person
{
    private $name;

    public function __construct(string $id, string $name)
    {
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