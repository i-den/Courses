<?php


namespace Game\StarSystems;


use Models\Ships\ShipInterface;

class StarSystem implements StarSystemInterface
{
    private $name;
    private $neighbours = array();
    /** @var  ShipInterface[] */
    private $ships;

    public function __construct(string $name)
    {
        $this->setName($name);
    }

    public function isNeighbour(string $starSystemName): bool
    {
        return array_key_exists($starSystemName, $this->neighbours);
    }

    public function addNeighbour(string $starSystemName, int $requiredFuel): StarSystemInterface
    {
        $this->neighbours[$starSystemName] = $requiredFuel;
        return $this;
    }

    public function getName(): string
    {
        return $this->name;
    }

    public function setName(string $name): StarSystemInterface
    {
        $this->name = $name;
        return $this;
    }

    public function getRequiredFuelToJumpTo(string $starSystemName)
    {
        return $this->neighbours[$starSystemName];
    }

    public function addShip(ShipInterface $ship)
    {
        $this->ships[] = $ship;
    }

    public function removeShip(ShipInterface $ship)
    {
        $filteredShips = array_filter($this->ships, function (ShipInterface $currentShip) use ($ship) {
            return $currentShip->getName() !== $ship->getName();
        });

        $this->ships = $filteredShips;
    }
}