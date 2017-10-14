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
     * @param Person $person
     */
    public function addPerson($person)
    {
        $personToFind = $this->findPerson($person->getName());
        if (!isset($personToFind)) {
            $this->citizen[] = $person;
        }
    }

    public function findPerson(string $name)
    {
        foreach ($this->citizen as $person) {
            if ($person->getName() === $name) {
                return $person;
            }
        }
        return null;
    }

    public function getFoodUnits(): int
    {
        $foodUnits = 0;
        foreach ($this->citizen as $person) {
            $foodUnits += $person->getFood();
        }
        return $foodUnits;
    }

    /**
     * @return Person[]
     */
    public function getCitizen(): array
    {
        return $this->citizen;
    }

    public function getName(): string
    {
        return $this->name;
    }

    private function setName($name): City
    {
        $this->name = $name;
        return $this;
    }
}