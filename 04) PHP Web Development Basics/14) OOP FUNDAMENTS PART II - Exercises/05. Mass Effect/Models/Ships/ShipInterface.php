<?php


namespace Models\Ships;


use Models\Enhancements\EnhancementsInterface;

interface ShipInterface
{
    public function addEnhancement(EnhancementsInterface $enhancement);

    public function attack(ShipAbstract $ship);

    public function reduceHealth(int $damage);

    public function reduceShields(int $damage);
}