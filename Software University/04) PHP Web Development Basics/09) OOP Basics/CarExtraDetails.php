<?php

namespace Van\Classes;

class CarExtraDetails
{
    /**
     * @var string
     */
    private $engine;

    /**
     * @var int
     */
    private $numberOfSeats;

    /**
     * @var int
     */
    private $horsepower;

    public function __construct(string $engine, int $numberOfSeats, int $horsepower)
    {
        $this->engine = $engine;
        $this->numberOfSeats = $numberOfSeats;
        $this->horsepower = $horsepower;
    }

    /**
     * @return string
     */
    public function getEngine(): string
    {
        return $this->engine;
    }

    /**
     * @param string $engine
     */
    public function setEngine(string $engine)
    {
        $this->engine = $engine;
    }

    /**
     * @return int
     */
    public function getNumberOfSeats(): int
    {
        return $this->numberOfSeats;
    }

    /**
     * @param int $numberOfSeats
     */
    public function setNumberOfSeats(int $numberOfSeats)
    {
        $this->numberOfSeats = $numberOfSeats;
    }

    /**
     * @return int
     */
    public function getHorsepower(): int
    {
        return $this->horsepower;
    }

    /**
     * @param int $horsepower
     */
    public function setHorsepower(int $horsepower)
    {
        $this->horsepower = $horsepower;
    }
}