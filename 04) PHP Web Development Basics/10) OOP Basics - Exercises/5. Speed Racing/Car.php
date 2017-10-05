<?php

namespace Van\Classes;

class Car
{
    /**
     * @var string
     */
    private $model;

    /**
     * @var float
     */
    private $fuelLeft;

    /**
     * @var float
     */
    private $fuelPerKm;

    /**
     * @var int
     */
    private $distanceTraveled;

    /**
     * Car constructor.
     *
     * @param string $model
     * @param float $fuelLeft
     * @param float $fuelPerKm
     * @param int $distanceTraveled
     */
    public function __construct(
        string $model,
        float $fuelLeft,
        float $fuelPerKm,
        int $distanceTraveled = 0
    )
    {
        $this->model = $model;
        $this->fuelLeft = $fuelLeft;
        $this->fuelPerKm = $fuelPerKm;
        $this->distanceTraveled = $distanceTraveled;
    }

    /**
     * Checks if the current Car instance has enough fuel to drive
     *
     * @param float $fuelToExhaust
     * @return bool
     */
    public function hasFuelToDrive(float $fuelToExhaust): bool
    {
        return $fuelToExhaust <= $this->fuelLeft;
    }

    /**
     * Drives the current Car instance by deducting Fuel and increasing DistanceTraveled
     * Not overriding __toString() for now
     *
     * @param float $fuelToExhaust
     * @param int $distanceToTravel
     */
    public function drive(float $fuelToExhaust, int $distanceToTravel): void
    {
        $this->fuelLeft -= $fuelToExhaust;
        $this->distanceTraveled += $distanceToTravel;
    }

    /**
     * Prints the Model, FuelLeft and DistanceTraveled
     */
    public function printStats(): void
    {
        $fuelLeft = number_format($this->fuelLeft, 2);
        echo $this->model . ' ' . $fuelLeft . ' ' . $this->distanceTraveled . PHP_EOL;
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
     * @return float
     */
    public function getFuelLeft(): float
    {
        return $this->fuelLeft;
    }

    /**
     * @param float $fuelLeft
     */
    public function setFuelLeft(float $fuelLeft)
    {
        $this->fuelLeft = $fuelLeft;
    }

    /**
     * @return float
     */
    public function getFuelPerKm(): float
    {
        return $this->fuelPerKm;
    }

    /**
     * @param float $fuelPerKm
     */
    public function setFuelPerKm(float $fuelPerKm)
    {
        $this->fuelPerKm = $fuelPerKm;
    }

    /**
     * @return int
     */
    public function getDistanceTraveled(): int
    {
        return $this->distanceTraveled;
    }

    /**
     * @param int $distanceTraveled
     */
    public function setDistanceTraveled(int $distanceTraveled)
    {
        $this->distanceTraveled = $distanceTraveled;
    }
}
