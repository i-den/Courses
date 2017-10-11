<?php


namespace Game;


use Game\StarSystems\StarSystemInterface;

interface GalaxyInterface
{

    public function getStarSystem(string $name): StarSystemInterface;

    public function addStarSystem(string $name, StarSystemInterface $starSystem);
}