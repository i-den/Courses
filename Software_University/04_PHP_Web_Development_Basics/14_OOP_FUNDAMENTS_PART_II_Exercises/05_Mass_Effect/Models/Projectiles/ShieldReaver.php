<?php


namespace Models\Projectiles;


use Models\Ships\ShipAbstract;

class ShieldReaver implements ProjectileInterface
{
    public function hit(int $damage, ShipAbstract $ship)
    {
        $ship->reduceShields($damage * 2);
        $ship->reduceHealth($damage);
    }
}