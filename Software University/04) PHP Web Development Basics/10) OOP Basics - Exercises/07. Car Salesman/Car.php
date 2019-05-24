<?php

namespace Van\Classes;

use Van\Classes\Engine;

include './Engine.php';

class Car
{
    /**
     * @var string
     */
    private $model;

    /**
     * @var Engine
     */
    private $engine;

    /**
     * @var int
     */
    private $weight;

    /**
     * @var string
     */
    private $color;

    /**
     * Car constructor.
     *
     * @param string $model
     * @param Engine $engine
     */
    public function __construct(string $model, Engine $engine)
    {
        $this->model = $model;
        $this->engine = $engine;
    }

    public function __toString()
    {
        $weight = isset($this->weight)
            ? $this->weight
            : 'n/a';
        $color = isset($this->color)
            ? $this->color
            : 'n/a';

        $displacement = $this->engine->hasDisplacement()
            ? $this->engine->getDisplacement()
            : 'n/a';
        $efficiency = $this->engine->hasEfficiency()
            ? $this->engine->getEfficiency()
            : 'n/a';

        $stringToReturn = $this->model . ':' . PHP_EOL;
        $stringToReturn .= '  ' . $this->engine->getModel() . ':' . PHP_EOL;
        $stringToReturn .= '    Power: ' . $this->engine->getPower() . PHP_EOL;
        $stringToReturn .= '    Displacement: ' . $displacement . PHP_EOL;
        $stringToReturn .= '    Efficiency: ' . $efficiency . PHP_EOL;
        $stringToReturn .= '  Weight: ' . $weight . PHP_EOL;
        $stringToReturn .= '  Color: ' . $color . PHP_EOL;

        return $stringToReturn;
    }

    /**
     * @return int
     */
    public function getWeight(): int
    {
        return $this->weight;
    }

    /**
     * @param int $weight
     */
    public function setWeight(int $weight)
    {
        $this->weight = $weight;
    }

    /**
     * @return string
     */
    public function getColor(): string
    {
        return $this->color;
    }

    /**
     * @param string $color
     */
    public function setColor(string $color)
    {
        $this->color = $color;
    }
}
