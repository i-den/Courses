<?php


namespace Models\Ships;


use Game\StarSystems\StarSystemInterface;
use Models\Enhancements\EnhancementsInterface;
use Models\Projectiles\ProjectileInterface;

abstract class ShipAbstract implements ShipInterface
{
    protected $type;
    protected $name;
    protected $starSystem;

    protected $health;
    protected $damage;
    protected $shields;
    protected $fuel;

    protected $isAlive = true;

    /** @var  ProjectileInterface */
    protected $projectile;

    /** @var EnhancementsInterface[] */
    protected $enhancements = array();

    protected function __construct(string $type, string $name, StarSystemInterface $starSystem)
    {
        $this->setName($name)
            ->setType($type)
            ->setStarSystem($starSystem);
    }

    public function addEnhancement(EnhancementsInterface $enhancement)
    {
        $enhancement->enhance($this);
        $this->enhancements[] = $enhancement;
    }

    public function attack(ShipAbstract $ship)
    {
        $this->getProjectile()->hit($this->getDamage(), $ship);
    }

    public function reduceHealth(int $damage)
    {
        $this->setHealth($this->getHealth() - $damage);
        if ($this->getHealth() <= 0) {
            $this->setHealth(0);
            $this->isAlive = false;
        }
    }

    public function reduceShields(int $damage)
    {
        $this->setShields($this->getShields() - $damage);
        if ($this->getShields() < 0) {
            $this->setShields(0);
        }
    }

    public function getName()
    {
        return $this->name;
    }

    public function setName($name): ShipAbstract
    {
        $this->name = $name;
        return $this;
    }

    public function getType()
    {
        return $this->type;
    }

    public function setType($type): ShipAbstract
    {
        $this->type = $type;
        return $this;
    }

    public function getStarSystem()
    {
        return $this->starSystem;
    }

    public function setStarSystem(StarSystemInterface $starSystem): ShipAbstract
    {
        $this->starSystem = $starSystem;
        return $this;
    }

    public function getHealth()
    {
        return $this->health;
    }

    public function setHealth($health): ShipAbstract
    {
        $this->health = $health;
        return $this;
    }

    public function getDamage()
    {
        return $this->damage;
    }

    public function setDamage($damage): ShipAbstract
    {
        $this->damage = $damage;
        return $this;
    }

    public function getShields()
    {
        return $this->shields;
    }

    public function setShields($shields): ShipAbstract
    {
        $this->shields = $shields;
        return $this;
    }

    public function getFuel()
    {
        return $this->fuel;
    }

    public function setFuel($fuel): ShipAbstract
    {
        $this->fuel = $fuel;
        return $this;
    }

    public function getProjectile(): ProjectileInterface
    {
        return $this->projectile;
    }

    /**
     * @param ProjectileInterface $projectile
     * @return ShipAbstract
     */
    public function setProjectile(ProjectileInterface $projectile): ShipAbstract
    {
        $this->projectile = $projectile;
        return $this;
    }
}