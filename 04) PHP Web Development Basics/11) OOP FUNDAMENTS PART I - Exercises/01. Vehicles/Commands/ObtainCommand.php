<?php


class ObtainCommand implements CommandInterface
{

    public function execute()
    {
        $vehicleInformation = explode(' ', trim(fgets(STDIN)));

        $vehicleClass = 'Vehicles\\' . $vehicleInformation[0];
        $fuelQuantity = floatval($vehicleInformation[1]);
        $fuelConsumption = floatval($vehicleInformation[2]);

        return new $vehicleClass();
    }
}