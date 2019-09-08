<?php


namespace Models\Projectiles;


use Models\Ships\ShipAbstract;

class PenetrationShell implements ProjectileInterface
{
    public function hit(int $damage, ShipAbstract $ship)
    {
        $ship->reduceHealth($damage);
    }
}