<?php

namespace Van\ClassesC;

class Car
{
    /**
     * @var float
     */
    private $speed;

    /**
     * @var float
     */
    private $fuel;

    /**
     * @var float
     */
    private $fuelEconomy;

    /**
     * @var float
     */
    private $distanceTraveled;

    /**
     * @var float
     */
    private $timeTraveled = 0.0;

    /**
     * @var float
     */
    private $minutesPerKm;

    /**
     * @var float
     */
    private $fuelPerKm;

    /**
     * Car constructor.
     *
     * @param float $speed
     * @param float $fuel
     * @param float $fuelEconomy
     */
    public function __construct(float $speed, float $fuel, float $fuelEconomy)
    {
        $this->speed = $speed;
        $this->fuel = $fuel;
        $this->fuelEconomy = $fuelEconomy;
        $this->distanceTraveled = 0.0;
        $this->timeTraveled = 0.0;
        $this->minutesPerKm = 60 / $speed;
        $this->fuelPerKm = $this->fuelEconomy / 100;
    }

    /**
     * Travels the Car instance by checking it's fuel
     *
     * @param float $distance
     */
    public function travel(float $distance)
    {
        $neededFuel = $this->fuelPerKm * $distance;

        if ($neededFuel <= $this->fuel) {
            $this->fuel -= $neededFuel;
            $this->distanceTraveled += $distance;
            $this->timeTraveled += $distance * $this->minutesPerKm;
        } else {
            $possibleDistance = $this->fuel / $this->fuelPerKm;
            $this->distanceTraveled += $possibleDistance;
            $this->fuel = 0;
            $this->timeTraveled += $possibleDistance * $this->minutesPerKm;
        }
    }

    /**
     * Doubles the Fuel property
     *
     * @param float $fuel
     */
    public function refuel(float $fuel): void
    {
        $this->fuel += $fuel;
    }

    /**
     * Outputs the distanceTraveled property
     */
    public function printDistance(): void
    {
        $formatted = number_format(round($this->distanceTraveled, 1), 1);
        echo "Total Distance: {$formatted}" . PHP_EOL;
    }

    /**
     * Outputs the timeTraveled property
     */
    public function printTime(): void
    {
        $hours = floor($this->timeTraveled / 60);
        $minutes = floor($this->timeTraveled % 60);
        echo "Total Time: {$hours} hours and {$minutes} minutes" . PHP_EOL;
    }

    /**
     * Outputs the fuel property
     */
    public function printFuel(): void
    {
        $formatted = number_format(round($this->fuel, 1), 1);
        echo "Fuel left: {$formatted} liters" . PHP_EOL;
    }
}
