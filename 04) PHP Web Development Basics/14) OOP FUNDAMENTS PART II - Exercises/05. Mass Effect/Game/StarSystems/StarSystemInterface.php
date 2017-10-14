<?php


namespace Game\StarSystems;


use Models\Ships\ShipInterface;

interface StarSystemInterface
{
    public function addNeighbour(string $starSystemName, int $requiredFuel): StarSystemInterface;

    public function isNeighbour(string $starSystemName): bool;

    public function getRequiredFuelToJumpTo(string $starSystemName);

    public function getName(): string;

    public function addShip(ShipInterface $ship);

    public function removeShip(ShipInterface $ship);
}