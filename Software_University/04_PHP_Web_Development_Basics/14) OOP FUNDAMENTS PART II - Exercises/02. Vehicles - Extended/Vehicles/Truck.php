<?php

namespace Vehicles;


class Truck extends Vehicle
{
    const EXTRA_FUEL_CONSUMPTION = 1.6;
    const FUEL_LEAKAGE = 5;

    public function __construct(float $fuelQuantity, float $fuelConsumption, int $tankCapacity)
    {
        parent::__construct(
            $fuelQuantity,
            $fuelConsumption + self::EXTRA_FUEL_CONSUMPTION,
            $tankCapacity
        );
    }

    public function __toString()
    {
        $fuelLeft   = number_format($this->getFuelQuantity(), 2, '.', '');
        return 'Truck: ' . $fuelLeft . PHP_EOL;
    }

    public function refuel(float $fuel)
    {
        $fuelAfterRefueling = $this->getFuelQuantity() + ($fuel * ((100 - self::FUEL_LEAKAGE) / 100));
        parent::refuel($fuelAfterRefueling);
    }

    public function drive(float $distance)
    {
        $className = substr(self::class, strrpos(self::class, '\\') + 1);
        if ($this->canDrive($distance)) {
            echo $className . ' travelled ' . $distance . ' km' . PHP_EOL;
            parent::drive($distance);
        } else {
            throw new \Exception($className . ' needs refueling' . PHP_EOL);
        }
    }
}
