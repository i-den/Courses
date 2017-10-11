<?php


namespace Models\Ships;


use Game\GalaxyInterface;
use Game\StarSystems\StarSystemInterface;
use Models\Projectiles\Laser;

class Dreadnought extends ShipAbstract
{
    const SHIP_DREAD_HP = 200;
    const SHIP_DREAD_SHIELDS = 300;
    const SHIP_DREAD_DMG = 150;
    const SHIP_DREAD_FUEL = 700;

    public function __construct($type, $name, StarSystemInterface $starSystem, GalaxyInterface $galaxy)
    {
        $defaultProjectile = new Laser();
        $this->setHealth(self::SHIP_DREAD_HP)
            ->setShields(self::SHIP_DREAD_SHIELDS)
            ->setDamage(self::SHIP_DREAD_DMG)
            ->setFuel(self::SHIP_DREAD_FUEL)
            ->setProjectile($defaultProjectile);
        parent::__construct($type, $name, $starSystem, $galaxy);
    }
}