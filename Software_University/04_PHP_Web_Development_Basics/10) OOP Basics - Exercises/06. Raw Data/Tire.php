<?php

namespace Van\Classes;

class Tire
{
    /**
     * @var int
     */
    private $age;

    /**
     * @var float
     */
    private $pressure;

    /**
     * Tire constructor.
     *
     * @param int $age
     * @param float $pressure
     */
    public function __construct(int $age, float $pressure)
    {
        $this->age = $age;
        $this->pressure = $pressure;
    }

    /**
     * @return int
     */
    public function getAge(): int
    {
        return $this->age;
    }

    /**
     * @param int $age
     */
    public function setAge(int $age)
    {
        $this->age = $age;
    }

    /**
     * @return float
     */
    public function getPressure(): float
    {
        return $this->pressure;
    }

    /**
     * @param float $pressure
     */
    public function setPressure(float $pressure)
    {
        $this->pressure = $pressure;
    }
}