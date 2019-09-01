<?php

namespace Van\ClassesA;

class Car
{
    /**
     * @var string
     */
    private $model;

    /**
     * @var int
     */
    private $speed;

    /**
     * Car constructor.
     *
     * @param string $model
     * @param int $speed
     */
    public function __construct(string $model, int $speed)
    {
        $this->model = $model;
        $this->speed = $speed;
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
}
