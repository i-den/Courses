<?php


namespace Models\Ships;


use Game\StarSystems\StarSystemInterface;
use Models\Projectiles\PenetrationShell;

class Cruiser extends ShipAbstract
{
    const SHIP_CRU_HP = 100;
    const SHIP_CRU_SHIELDS = 100;
    const SHIP_CRU_DMG = 50;
    const SHIP_CRU_FUEL = 300;

    public function __construct($type, $name, StarSystemInterface $starSystem)
    {
        $defaultProjectile = new PenetrationShell();
        $this->setHealth(self::SHIP_CRU_HP)
            ->setShields(self::SHIP_CRU_SHIELDS)
            ->setDamage(self::SHIP_CRU_DMG)
            ->setFuel(self::SHIP_CRU_FUEL)
            ->setProjectile($defaultProjectile);
        parent::__construct($type, $name, $starSystem);
    }

}