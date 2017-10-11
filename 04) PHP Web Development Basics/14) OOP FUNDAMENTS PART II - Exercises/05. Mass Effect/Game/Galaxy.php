<?php


namespace Game;


use Game\StarSystems\StarSystemInterface;

class Galaxy implements GalaxyInterface
{
    const STS_ART_TAU = 'Artemis-Tau';
    const STS_SER_NEB = 'Serpent-Nebula';
    const STS_HAD_GAM = 'Hades-Gamma';
    const STS_KEP_VER = 'Kepler-Verge';
    const ART_SER_FUEL = 50;
    const ART_HAD_FUEL = 120;
    const SER_HAD_FUEL = 360;
    const HAD_KEP_FUEL = 145;

    private $name;

    /** @var  StarSystemInterface[] */
    private $starSystems = array();

    public function __construct(string $name)
    {
        $this->name = $name;
    }

    public function getStarSystem(string $name): StarSystemInterface
    {
        return $this->starSystems[$name];
    }

    public function addStarSystem(string $name, StarSystemInterface $starSystem)
    {
        $this->starSystems[$name] = $starSystem;
    }
}