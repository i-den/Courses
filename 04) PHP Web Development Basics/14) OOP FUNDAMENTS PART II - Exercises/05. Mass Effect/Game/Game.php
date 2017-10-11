<?php


namespace Game;


require_once './GameInterface.php';
require_once './GalaxyInterface.php';
require_once './Galaxy.php';
require_once './StarSystems/StarSystemInterface.php';
require_once './StarSystems/StarSystem.php';

require_once '../Models/Projectiles/ProjectileInterface.php';
require_once '../Models/Projectiles/Laser.php';
require_once '../Models/Projectiles/PenetrationShell.php';
require_once '../Models/Projectiles/ShieldReaver.php';

require_once '../Models/Enhancements/EnhancementsInterface.php';
require_once '../Models/Enhancements/ExtendedFuelCells.php';
require_once '../Models/Enhancements/KineticBarrier.php';
require_once '../Models/Enhancements/ThanixCannon.php';

require_once '../Models/Ships/ShipInterface.php';
require_once '../Models/Ships/ShipAbstract.php';
require_once '../Models/Ships/Frigate.php';
require_once '../Models/Ships/Cruiser.php';
require_once '../Models/Ships/Dreadnought.php';


use Game\StarSystems\StarSystem;
use Models\Enhancements\ThanixCannon;
use Models\Ships\Dreadnought;
use Models\Ships\Frigate;
use Models\Ships\Cruiser;

class Game implements GameInterface
{
    /** @var  GalaxyInterface */
    private $galaxy;

    public function start()
    {
        $this->galaxy = new Galaxy();
        $this->galaxy->addStarSystem($this->galaxy::STS_ART_TAU, new StarSystem($this->galaxy::STS_ART_TAU));
        $this->galaxy->addStarSystem($this->galaxy::STS_SER_NEB, new StarSystem($this->galaxy::STS_SER_NEB));
        $this->galaxy->addStarSystem($this->galaxy::STS_HAD_GAM, new StarSystem($this->galaxy::STS_HAD_GAM));
        $this->galaxy->addStarSystem($this->galaxy::STS_KEP_VER, new StarSystem($this->galaxy::STS_KEP_VER));

        $this->galaxy->getStarSystem($this->galaxy::STS_ART_TAU)
            ->addNeighbour($this->galaxy::STS_SER_NEB, $this->galaxy::ART_SER_FUEL)
            ->addNeighbour($this->galaxy::STS_KEP_VER, $this->galaxy::ART_HAD_FUEL);

        $this->galaxy->getStarSystem($this->galaxy::STS_SER_NEB)
            ->addNeighbour($this->galaxy::STS_ART_TAU, $this->galaxy::ART_SER_FUEL)
            ->addNeighbour($this->galaxy::STS_HAD_GAM, $this->galaxy::SER_HAD_FUEL);

        $this->galaxy->getStarSystem($this->galaxy::STS_HAD_GAM)
            ->addNeighbour($this->galaxy::STS_SER_NEB, $this->galaxy::SER_HAD_FUEL)
            ->addNeighbour($this->galaxy::STS_KEP_VER, $this->galaxy::HAD_KEP_FUEL);

        $this->galaxy->getStarSystem($this->galaxy::STS_KEP_VER)
            ->addNeighbour($this->galaxy::STS_HAD_GAM, $this->galaxy::HAD_KEP_FUEL)
            ->addNeighbour($this->galaxy::STS_ART_TAU, $this->galaxy::ART_HAD_FUEL);

        $frigate = new Frigate(
            'Frigate',
            'Normandy',
            $this->galaxy->getStarSystem($this->galaxy::STS_SER_NEB)
        );

        $cruiser = new Cruiser(
            'Cruiser',
            'Koshnica',
            $this->galaxy->getStarSystem($this->galaxy::STS_SER_NEB)
        );

        $dreadnought = new Dreadnought(
            'Dreadnought',
            'Torba',
            $this->galaxy->getStarSystem($this->galaxy::STS_SER_NEB)
        );

        echo 'Debug';

        $frigate->attack($cruiser);
        $cruiser->attack($dreadnought);
        $dreadnought->attack($frigate);
    }
}

$a = new Game();
$a->start();