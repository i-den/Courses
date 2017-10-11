<?php


namespace Models\Enhancements;


use Models\Ships\ShipAbstract;

class ThanixCannon implements EnhancementsInterface
{
    const ENH_THANIX_DMG = 50;

    public function enhance(ShipAbstract $ship)
    {
       $ship->setDamage($ship->getDamage() + self::ENH_THANIX_DMG);
    }
}