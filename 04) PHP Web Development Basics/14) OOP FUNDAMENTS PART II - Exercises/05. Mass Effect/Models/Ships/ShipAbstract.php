<?php


namespace Models\Ships;


use Game\GalaxyInterface;
use Game\StarSystems\StarSystemInterface;
use Models\Enhancements\EnhancementsAbstract;
use Models\Enhancements\EnhancementsInterface;
use Models\Projectiles\ProjectileInterface;

abstract class ShipAbstract implements ShipInterface
{
    protected $type;
    protected $name;
    /** @var  StarSystemInterface */
    protected $starSystem;
    /** @var  GalaxyInterface */
    protected $galaxy;

    protected $health;
    protected $damage;
    protected $shields;
    protected $fuel;

    protected $isAlive = true;

    /** @var  ProjectileInterface */
    protected $projectile;

    /** @var EnhancementsInterface[] */
    protected $enhancements = array();

    /**
     * ShipAbstract constructor.
     * @param string $type
     * @param string $name
     * @param StarSystemInterface $starSystem
     * @param GalaxyInterface $galaxy
     * @param EnhancementsAbstract[] $enhancements
     */
    protected function __construct(
        string $type,
        string $name,
        StarSystemInterface $starSystem,
        GalaxyInterface $galaxy,
        array $enhancements = null
    )
    {
        $this->setName($name)
            ->setType($type)
            ->setStarSystem($starSystem)
            ->setGalaxy($galaxy);

        if (isset($enhancements)) {
            foreach ($enhancements as $enhancement) {
                $enhClassName = 'Models\\Enhancements\\' . $enhancement;
                $enhancement = new $enhClassName();
                $this->addEnhancement($enhancement);
            }
        }

    }

    public function __toString()
    {
        $enhancements = empty($this->enhancements)
            ? 'N/A'
            : implode(', ', $this->enhancements);

        $shipOutput = '--' . $this->getName() . ' - ' . $this->getType() . PHP_EOL;
        $shipOutput .= '-Location: ' . $this->getStarSystem()->getName() . PHP_EOL;
        $shipOutput .= '-Health: ' . $this->getHealth() . PHP_EOL;
        $shipOutput .= '-Shields: ' . $this->getShields() . PHP_EOL;
        $shipOutput .= '-Damage: ' . $this->getDamage() . PHP_EOL;
        $shipOutput .= '-Fuel: ' . $this->getFuel() . PHP_EOL;
        $shipOutput .= '-Enhancements: ' . $enhancements . PHP_EOL;

        return $shipOutput;
    }

    public function addEnhancement(EnhancementsInterface $enhancement)
    {
        $enhancement->enhance($this);
        $this->enhancements[] = $enhancement;
    }

    public function attack(ShipAbstract $ship)
    {
        if (!$this->isAlive() || !$ship->isAlive()) {
            throw new \Exception('Ship is destroyed' . PHP_EOL);
        } else if ($this->getStarSystem() !== $ship->getStarSystem()) {
            throw new \Exception('No such ship in star system' . PHP_EOL);
        }

        $this->getProjectile()->hit($this->getDamage(), $ship);

        if (!$ship->isAlive()) {
            echo $ship->getName() . ' has been destroyed' . PHP_EOL;
        } else {
            echo $this->getName() . ' attacked ' . $ship->getName() . PHP_EOL;
        }
    }

    public function plotJump(string $starSystemName)
    {
        if ($this->getStarSystem()->getName() === $starSystemName) {
            throw new \Exception('Ship is already in ' . $starSystemName . PHP_EOL);
        } else if (!$this->getStarSystem()->isNeighbour($starSystemName)) {
            throw new \Exception($starSystemName . ' is not in the neighbourhood' . PHP_EOL);
        }

        $requiredFuelForTheJump = $this->getStarSystem()->getRequiredFuelToJumpTo($starSystemName);
        if (!($this->getFuel() >= $requiredFuelForTheJump)) {
            throw new \Exception('Not enough fuel for the jump to ' . $starSystemName . PHP_EOL);
        }

        $this->setFuel($this->getFuel() - $requiredFuelForTheJump);
        echo $this->getName() . ' jumped from ' . $this->getStarSystem()->getName() . ' to ' . $starSystemName;
        $this->setStarSystem($this->galaxy->getStarSystem($starSystemName));
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

    protected function isAlive(): bool
    {
        return $this->isAlive;
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

    public function setGalaxy(GalaxyInterface $galaxy): ShipAbstract
    {
        $this->galaxy = $galaxy;
        return $this;
    }
}