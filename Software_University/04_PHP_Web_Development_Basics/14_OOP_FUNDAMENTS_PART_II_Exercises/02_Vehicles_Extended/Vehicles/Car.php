<?php

namespace Vehicles;


class Car extends Vehicle
{
    const EXTRA_FUEL_CONSUMPTION = 0.9;

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
        $fuelLeft = number_format($this->getFuelQuantity(), 2, '.', '');
        return 'Car: ' . $fuelLeft . PHP_EOL;
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

    public function refuel(float $fuel)
    {
        $fuelAfterRefueling = $this->getFuelQuantity() + $fuel;
        if ($fuelAfterRefueling > $this->getTankCapacity()) {
            throw new \Exception('Cannot fit fuel in tank' . PHP_EOL);
        }

        parent::refuel($fuelAfterRefueling);
    }
}
