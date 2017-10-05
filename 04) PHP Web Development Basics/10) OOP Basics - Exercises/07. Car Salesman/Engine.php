<?php

namespace Van\Classes;

class Engine
{
    /**
     * @var string
     */
    private $model;

    /**
     * @var int
     */
    private $power;

    /**
     * @var int
     */
    private $displacement;

    /**
     * @var string
     */
    private $efficiency;

    /**
     * Engine constructor.
     *
     * @param string $model
     * @param int $power
     */
    public function __construct(string $model, int $power)
    {
        $this->model = $model;
        $this->power = $power;
    }

    /**
     * Checks if the optional property Displacement is set
     *
     * @return bool
     */
    public function hasDisplacement(): bool
    {
        return isset($this->displacement);
    }

    /**
     * Checks if the optional property Efficiency is set
     *
     * @return bool
     */
    public function hasEfficiency(): bool
    {
        return isset($this->efficiency);
    }

    /**
     * @return string
     */
    public function getModel(): string
    {
        return $this->model;
    }

    /**
     * @param string $model
     */
    public function setModel(string $model)
    {
        $this->model = $model;
    }

    /**
     * @return int
     */
    public function getPower(): int
    {
        return $this->power;
    }

    /**
     * @param int $power
     */
    public function setPower(int $power)
    {
        $this->power = $power;
    }

    /**
     * @return int
     */
    public function getDisplacement(): int
    {
        return $this->displacement;
    }

    /**
     * @param int $displacement
     */
    public function setDisplacement(int $displacement)
    {
        $this->displacement = $displacement;
    }

    /**
     * @return string
     */
    public function getEfficiency(): string
    {
        return $this->efficiency;
    }

    /**
     * @param string $efficiency
     */
    public function setEfficiency(string $efficiency)
    {
        $this->efficiency = $efficiency;
    }
}
