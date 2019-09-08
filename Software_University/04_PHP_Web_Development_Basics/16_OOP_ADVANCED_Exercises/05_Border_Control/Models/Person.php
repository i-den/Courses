<?php


namespace Models;


abstract class Person
{
    protected $id;

    protected $isDetained = false;

    protected function __construct(string $id)
    {
        $this->setId($id);
    }

    public function getId()
    {
        return $this->id;
    }

    public function setId($id): Person
    {
        $this->id = $id;
        return $this;
    }

    public function detain(): Person
    {
        $this->isDetained = true;
        return $this;
    }

    public function isDetained(): bool
    {
        return $this->isDetained;
    }
}