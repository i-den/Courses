<?php

namespace Van\ClassesA;

require_once './Company.php';
require_once './Pokemon.php';
require_once './Parents.php';
require_once './Child.php';
require_once './Car.php';

class Person
{
    /**
     * @var string
     */
    private $name;

    /**
     * @var Company
     */
    private $company;

    /**
     * @var array
     */
    private $pokemon;

    /**
     * @var array
     */
    private $parents;

    /**
     * @var array
     */
    private $children;

    /**
     * @var Car
     */
    private $car;

    /**
     * Person constructor.
     *
     * @param string $name
     */
    public function __construct(string $name)
    {
        $this->name = $name;
    }

    /**
     * @return string
     */
    public function __toString()
    {
        $company = isset($this->company)
            ? PHP_EOL . $this->company->getName() . ' '
            . $this->company->getDepartment() . ' '
            . $this->company->getSalary() . PHP_EOL
            : PHP_EOL;
        $car = isset($this->car)
            ? PHP_EOL . $this->car->getModel() . ' '
            . $this->car->getSpeed() . PHP_EOL
            : PHP_EOL;
        $pokemon = isset($this->pokemon)
            ? $this->listPokemon()
            : PHP_EOL;
        $parents = isset($this->parents)
            ? $this->listParents()
            : PHP_EOL;
        $children = isset($this->children)
            ? $this->listChildren()
            : PHP_EOL;

        $stringToReturn = $this->name . PHP_EOL;
        $stringToReturn .= 'Company:' . $company;
        $stringToReturn .= 'Car:' . $car;
        $stringToReturn .= 'Pokemon:' . $pokemon;
        $stringToReturn .= 'Parents:' . $parents;
        $stringToReturn .= 'Children:' . $children;

        return $stringToReturn;
    }

    /**
     * Puts all instances of the Pokemon class
     * in the Pokemon array proerty
     * in a string and returns it
     *
     * @return string
     */
    private function listPokemon(): string
    {
        $stringToReturn = PHP_EOL;

        foreach ($this->pokemon as $currPokemon) {
            $stringToReturn .= $currPokemon->getName() . ' ' . $currPokemon->getType() . PHP_EOL;
        }

        return $stringToReturn;
    }

    /**
     * Same as listPokemon and listChildren
     * but applied to the Parents array
     *
     * @return string
     */
    private function listParents(): string
    {
        $stringToReturn = PHP_EOL;

        foreach ($this->parents as $currParent) {
            $stringToReturn .= $currParent->getName() . ' ' . $currParent->getBirthday() . PHP_EOL;
        }

        return $stringToReturn;
    }

    /**
     * Same as listPokemon and listParents
     * but applied to the Children array
     *
     * @return string
     */
    private function listChildren(): string
    {
        $stringToReturn = PHP_EOL;

        foreach ($this->children as $child) {
            $stringToReturn .= $child->getName() . ' ' . $child->getBirthday() . PHP_EOL;
        }

        return $stringToReturn;
    }

    /**
     * @return string
     */
    public function getName(): string
    {
        return $this->name;
    }

    /**
     * @param string $name
     */
    public function setName(string $name)
    {
        $this->name = $name;
    }

    /**
     * @return Company
     */
    public function getCompany(): Company
    {
        return $this->company;
    }

    /**
     * @param Company $company
     */
    public function setCompany(Company $company)
    {
        $this->company = $company;
    }

    /**
     * @return array
     */
    public function getPokemon(): array
    {
        return $this->pokemon;
    }

    /**
     * @param Pokemon $pokemon
     */
    public function addPokemon(Pokemon $pokemon)
    {
        $this->pokemon[] = $pokemon;
    }

    /**
     * @return array
     */
    public function getParents(): array
    {
        return $this->parents;
    }

    /**
     * @param Parents $parents
     */
    public function addParent(Parents $parents)
    {
        $this->parents[] = $parents;
    }

    /**
     * @return array
     */
    public function getChildren(): array
    {
        return $this->children;
    }

    /**
     * @param Child $children
     */
    public function addChildren(Child $children)
    {
        $this->children[] = $children;
    }

    /**
     * @return Car
     */
    public function getCar(): Car
    {
        return $this->car;
    }

    /**
     * @param Car $car
     */
    public function setCar(Car $car)
    {
        $this->car = $car;
    }
}
