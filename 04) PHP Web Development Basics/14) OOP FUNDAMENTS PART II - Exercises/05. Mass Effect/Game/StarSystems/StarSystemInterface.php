<?php


namespace Game\StarSystems;


interface StarSystemInterface
{
    public function addNeighbour(string $starSystemName, int $requiredFuel): StarSystemInterface;

    public function isNeighbour(string $starSystemName): bool;

    public function getRequiredFuelToJumpTo(string $starSystemName);

    public function getName(): string;
}