<?php

namespace Van\Classes;

class Engine
{
    /**
     * @var int
     */
    private $speed;

    /**
     * @var int
     */
    private $power;

    /**
     * Engine constructor.
     *
     * @param int $speed
     * @param int $power
     */
    public function __construct(int $speed, int $power)
    {
        $this->speed = $speed;
        $this->power = $power;
    }

    /**
     * @return int
     */
    public function getSpeed(): int
    {
        return $this->speed;
    }

    /**
     * @param int $speed
     */
    public function setSpeed(int $speed)
    {
        $this->speed = $speed;
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
}