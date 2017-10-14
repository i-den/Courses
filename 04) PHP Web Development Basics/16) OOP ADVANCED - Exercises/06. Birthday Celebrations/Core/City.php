<?php


namespace Core;


use Models\IBirthable;
use Models\Person;
use Models\Pet;

class City
{
    private $name;

    /**
     * @var Person[] | Pet[]
     */
    private $citizen = array();

    public function __construct(string $name)
    {
        $this->setName($name);
    }

    /**
     * @param Person | Pet
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
        $detainedPeople = array_filter($this->getCitizen(), function (Person $citizen) {
            return $citizen->isDetained();
        });

        return $detainedPeople;
    }

    public function getLivingThingsBornIn(string $year)
    {
        $livingThingsBornIn = array_filter(
            $this->getCitizen(),
            function (IBirthable $livingThing) use ($year) {
                $livingThingYear = substr(
                    $livingThing->getBirthday(),
                    strrpos($livingThing->getBirthday(), '/') + 1
                );
                return $livingThingYear === $year;
            });

        return $livingThingsBornIn;
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