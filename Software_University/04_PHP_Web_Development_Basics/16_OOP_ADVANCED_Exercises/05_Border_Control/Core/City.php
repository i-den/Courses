<?php


namespace Core;


use Models\Person;

class City
{
    private $name;

    /**
     * @var Person[]
     */
    private $citizen = array();

    public function __construct(string $name)
    {
        $this->setName($name);
    }

    /**
     * @param Person
     */
    public function addCitizen($citizen)
    {
        $this->citizen[] = $citizen;
    }

    /**
     * @return Person[]
     */
    public function getCitizen(): array
    {
        return $this->citizen;
    }

    public function getDetainedCitizen(): array
    {
        $detainedPeople = array_filter($this->getCitizen(), function(Person $citizen) {
           return $citizen->isDetained();
        });

        return $detainedPeople;
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setName($name): City
    {
        $this->name = $name;
        return $this;
    }
}