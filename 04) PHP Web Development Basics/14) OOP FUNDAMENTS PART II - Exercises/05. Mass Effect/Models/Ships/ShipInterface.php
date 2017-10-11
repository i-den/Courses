<?php


namespace Models\Ships;


use Game\StarSystems\StarSystem;
use Game\StarSystems\StarSystemInterface;
use Models\Enhancements\EnhancementsInterface;

interface ShipInterface
{
    public function addEnhancement(EnhancementsInterface $enhancement);

    public function attack(ShipAbstract $ship);

    public function reduceHealth(int $damage);

    public function reduceShields(int $damage);

    public function plotJump(string $starSystemName);

    public function __toString();
}