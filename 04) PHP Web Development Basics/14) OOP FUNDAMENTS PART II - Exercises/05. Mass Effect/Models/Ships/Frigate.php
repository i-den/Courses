<?php


namespace Models\Ships;


use Game\StarSystems\StarSystemInterface;
use Models\Projectiles\ShieldReaver;

class Frigate extends ShipAbstract
{
    const SHIP_FRIG_HP = 60;
    const SHIP_FRIG_SHIELDS = 50;
    const SHIP_FRIG_DMG = 30;
    const SHIP_FRIG_FUEL = 220;

    public function __construct($type, $name, StarSystemInterface $starSystem)
    {
        $defaultProjectile = new ShieldReaver();
        $this->setHealth(self::SHIP_FRIG_HP)
            ->setShields(self::SHIP_FRIG_SHIELDS)
            ->setDamage(self::SHIP_FRIG_DMG)
            ->setFuel(self::SHIP_FRIG_FUEL)
            ->setProjectile($defaultProjectile);
        parent::__construct($type, $name, $starSystem);
    }

    public function respondToAttack()
    {

    }
}