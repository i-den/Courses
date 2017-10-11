<?php


namespace Models\Projectiles;


use Models\Ships\ShipAbstract;

interface ProjectileInterface
{
    public function hit(int $damage, ShipAbstract $ship);
}