<?php


namespace Vehicles;


class Bus extends Vehicle
{
    const EXTRA_FUEL_CONSUMPTION = 1.4;

    public function __construct($fuelQuantity, $fuelConsumption, $tankCapacity)
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
        return 'Bus: ' . $fuelLeft . PHP_EOL;
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

    public function driveEmpty(float $distance)
    {
        $tempFuelConsumption = $this->getFuelConsumption();
        $this->setFuelConsumption($tempFuelConsumption - self::EXTRA_FUEL_CONSUMPTION);
        $this->drive($distance);
        $this->setFuelConsumption($tempFuelConsumption);
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