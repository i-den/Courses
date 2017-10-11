<?php


namespace Models\Projectiles;


use Models\Ships\ShipAbstract;

class Laser implements ProjectileInterface
{
    public function hit(int $damage, ShipAbstract $ship)
    {
        if ($damage > $ship->getShields()) {
            $damage -= $ship->getShields();
            $ship->setShields(0);
            $ship->reduceHealth($damage);
        } else if ($damage === $ship->getShields()) {
            $ship->setShields(0);
        } else {
            $ship->reduceShields($damage);
        }
    }
}