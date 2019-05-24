<?php


namespace Models\Enhancements;


use Models\Ships\ShipAbstract;

class KineticBarrier extends EnhancementsAbstract
{
    const ENH_KINETIC_SHIELDS = 100;

    public function enhance(ShipAbstract $ship)
    {
        $ship->setShields($ship->getShields() + self::ENH_KINETIC_SHIELDS);
    }
}