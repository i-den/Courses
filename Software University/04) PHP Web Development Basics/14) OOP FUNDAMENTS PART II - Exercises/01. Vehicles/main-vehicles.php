<?php

require_once './Vehicles/VehicleInterface.php';
require_once './Vehicles/Vehicle.php';
require_once './Vehicles/Car.php';
require_once './Vehicles/Truck.php';

use Vehicles\Car;
use Vehicles\Truck;

$carInfo = explode(' ', trim(fgets(STDIN)));
$carFuelQuantity = floatval($carInfo[1]);
$carFuelConsumption = floatval($carInfo[2]);

$truckInfo = explode(' ', trim(fgets(STDIN)));
$truckFuelQuantity = floatval($truckInfo[1]);
$truckFuelConsumption = floatval($truckInfo[2]);

$car = new Car($carFuelQuantity, $carFuelConsumption);
$truck = new Truck($truckFuelQuantity, $truckFuelConsumption);

$commandCount = intval(trim(fgets(STDIN)));

for ($i = 0; $i < $commandCount; $i++) {
    $commandInfo = explode(' ', trim(fgets(STDIN)));

    switch ($commandInfo[0]) {
        case 'Drive':
            $distanceToDrive = floatval($commandInfo[2]);
            if ($commandInfo[1] == 'Car') {
                try {
                    $car->drive($distanceToDrive);
                } catch (Exception $exception) {
                    echo $exception->getMessage();
                }
            } else {
                try {
                    $truck->drive($distanceToDrive);
                } catch (Exception $exception) {
                    echo $exception->getMessage();
                }
            }
            break;
        case 'Refuel':
            $refuelAmount = floatval($commandInfo[2]);
            if ($commandInfo[1] == 'Car') {
                $car->refuel($refuelAmount);
            } else {
                $truck->refuel($refuelAmount);
            }
    }
}

echo $car;
echo $truck;