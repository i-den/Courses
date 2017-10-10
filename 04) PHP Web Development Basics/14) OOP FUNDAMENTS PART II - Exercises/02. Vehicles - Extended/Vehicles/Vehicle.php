<?php

namespace Vehicles;


abstract class Vehicle implements VehicleInterface
{
    /** @var  float */
    protected $fuelQuantity;

    /** @var  float */
    protected $fuelConsumption;

    /** @var  int */
    protected $tankCapacity;

    public function __construct(float $fuelQuantity, float $fuelConsumption, int $tankCapacity)
    {
        $this->setFuelQuantity($fuelQuantity)
            ->setFuelConsumption($fuelConsumption)
            ->setTankCapacity($tankCapacity);
    }

    public function refuel(float $fuelAfterRefueling)
    {
        if ($fuelAfterRefueling < 0) {
            throw new \Exception('Fuel must be a positive number' . PHP_EOL);
        }

        $this->setFuelQuantity($fuelAfterRefueling);
    }

    protected function canDrive(float $distance): bool
    {
        $fuelToConsume = $this->fuelConsumption * $distance;
        return $this->getFuelQuantity() > $fuelToConsume;
    }

    public function drive(float $distance)
    {
        $fuelToExhaust = $this->getFuelConsumption() * $distance;
        $this->exhaustFuel($fuelToExhaust);
    }

    private function exhaustFuel(float $fuelToExhaust)
    {
        $this->fuelQuantity -= $fuelToExhaust;
    }

    protected function getFuelQuantity(): float
    {
        return $this->fuelQuantity;
    }

    protected function setFuelQuantity(float $fuelQuantity): Vehicle
    {
        $this->fuelQuantity = $fuelQuantity;
        return $this;
    }

    protected function getFuelConsumption(): float
    {
        return $this->fuelConsumption;
    }

    protected function setFuelConsumption(float $fuelConsumption): Vehicle
    {
        $this->fuelConsumption = $fuelConsumption;
        return $this;
    }

    protected function getTankCapacity(): int
    {
        return $this->tankCapacity;
    }

    protected function setTankCapacity(int $tankCapacity): Vehicle
    {
        $this->tankCapacity = $tankCapacity;
        return $this;
    }
}
