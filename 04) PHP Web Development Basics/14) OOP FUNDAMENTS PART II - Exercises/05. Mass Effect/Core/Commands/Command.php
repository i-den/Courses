<?php


namespace Core\Commands;


use Game\GalaxyInterface;

abstract class Command implements IExecutable
{
    /**
     * @var GalaxyInterface
     */
    protected $galaxy;

    public function __construct(GalaxyInterface $galaxy)
    {
        $this->setGalaxy($galaxy);
    }

    protected function setGalaxy(GalaxyInterface $galaxy): Command
    {
        $this->galaxy = $galaxy;
        return $this;
    }

    protected function getGalaxy(): GalaxyInterface
    {
        return $this->galaxy;
    }
}