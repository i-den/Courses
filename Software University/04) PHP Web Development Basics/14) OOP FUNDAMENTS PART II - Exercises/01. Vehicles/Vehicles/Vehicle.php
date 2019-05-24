<?php

namespace Vehicles;


abstract class Vehicle implements VehicleInterface
{
    /** @var  float */
    protected $fuelQuantity;

    /** @var  float */
    protected $fuelConsumption;

    public function __construct(float $fuelQuantity, float $fuelConsumption)
    {
        $this->setFuelQuantity($fuelQuantity)
            ->setFuelConsumption($fuelConsumption);
    }

    public function refuel(float $fuel)
    {
        $this->fuelQuantity += $fuel;
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
}
