<?php


namespace Family;


abstract class Person implements PersonInterface
{
    protected $name;
    protected $birthYear;
    protected $deathYear;

    public function __construct(string $name, \DateTime $birthYear, \DateTime $deathYear)
    {
        $this->setName($name)
            ->setBirthYear($birthYear)
            ->setDeathYear($deathYear);
    }

    public function getTimeLived()
    {
        $dateDiff = $this->getDeathYear()->diff($this->getBirthYear());
        return $dateDiff;
    }

    public function getName()
    {
        return $this->name;
    }

    public function setName($name): Person
    {
        if (strlen($name) < 3) {
            throw new \Exception('Name should be at least 3 characters long');
        }

        $this->name = $name;
        return $this;
    }

    public function getBirthYear(): \DateTime
    {
        return $this->birthYear;
    }

    public function setBirthYear($birthYear): Person
    {
        $this->birthYear = $birthYear;
        return $this;
    }

    public function getDeathYear(): \DateTime
    {
        return $this->deathYear;
    }

    public function setDeathYear($deathYear): Person
    {
        $this->deathYear = $deathYear;
        return $this;
    }
}