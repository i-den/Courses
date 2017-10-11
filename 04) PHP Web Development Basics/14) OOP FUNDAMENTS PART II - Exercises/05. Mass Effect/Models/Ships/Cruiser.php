<?php


namespace Models\Ships;


use Game\GalaxyInterface;
use Game\StarSystems\StarSystemInterface;
use Models\Projectiles\PenetrationShell;
use Models\Projectiles\ProjectileInterface;

class Cruiser extends ShipAbstract
{
    const SHIP_CRU_HP = 100;
    const SHIP_CRU_SHIELDS = 100;
    const SHIP_CRU_DMG = 50;
    const SHIP_CRU_FUEL = 300;

    private $projectilesFired = 0;

    public function __construct($type, $name, StarSystemInterface $starSystem, GalaxyInterface $galaxy)
    {
        $defaultProjectile = new PenetrationShell();
        $this->setHealth    (self::SHIP_CRU_HP)
            ->setShields    (self::SHIP_CRU_SHIELDS)
            ->setDamage     (self::SHIP_CRU_DMG)
            ->setFuel       (self::SHIP_CRU_FUEL)
            ->setProjectile ($defaultProjectile);
        parent::__construct ($type, $name, $starSystem, $galaxy);
    }

    public function __toString()
    {
        $cruiserOutput  = parent::__toString();
        $cruiserOutput .= '-Projectiles fired: ' . $this->projectilesFired . PHP_EOL;

        return $cruiserOutput;
    }

    public function getProjectile(): ProjectileInterface
    {
        $this->projectilesFired++;
        return parent::getProjectile();
    }
}