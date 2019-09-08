<?php

require_once './Vehicles/VehicleInterface.php';
require_once './Vehicles/Vehicle.php';
require_once './Vehicles/Car.php';
require_once './Vehicles/Truck.php';
require_once './Vehicles/Bus.php';

use Vehicles\Car;
use Vehicles\Truck;
use Vehicles\Bus;

$carInfo = explode(' ', trim(fgets(STDIN)));
$carFuelQuantity = floatval($carInfo[1]);
$carFuelConsumption = floatval($carInfo[2]);
$carTankCapacity = intval($carInfo[3]);

$truckInfo = explode(' ', trim(fgets(STDIN)));
$truckFuelQuantity = floatval($truckInfo[1]);
$truckFuelConsumption = floatval($truckInfo[2]);
$truckTankCapacity = intval($truckInfo[3]);

$busInfo = explode(' ', trim(fgets(STDIN)));
$busFuelQuantity = floatval($busInfo[1]);
$busFuelConsumption = floatval($busInfo[2]);
$busTankCapacity = intval($busInfo[3]);


$car = new Car($carFuelQuantity, $carFuelConsumption, $carTankCapacity);

$truck = new Truck($truckFuelQuantity, $truckFuelConsumption, $truckTankCapacity);

$bus = new Bus($busFuelQuantity, $busFuelConsumption, $busTankCapacity);

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
            } else if ($commandInfo[1] == 'Truck') {
                try {
                    $truck->drive($distanceToDrive);
                } catch (Exception $exception) {
                    echo $exception->getMessage();
                }
            } else {
                try {
                    $bus->drive($distanceToDrive);
                } catch (Exception $exception) {
                    echo $exception->getMessage();
                }
            }
            break;
        case 'Refuel':
            $refuelAmount = floatval($commandInfo[2]);
            if ($commandInfo[1] == 'Car') {
                try {
                    $car->refuel($refuelAmount);
                } catch (\Exception $exception) {
                    echo $exception->getMessage();
                }

            } else if ($commandInfo[1] == 'Truck') {
                try {
                    $truck->refuel($refuelAmount);
                } catch (\Exception $exception) {
                    echo $exception->getMessage();
                }
            } else {
                try {
                    $bus->refuel($refuelAmount);
                } catch (\Exception $exception) {
                    echo $exception->getMessage();
                }
            }
            break;
        case 'DriveEmpty':
            $distanceToDrive = floatval($commandInfo[2]);
            try {
                $bus->driveEmpty($distanceToDrive);
            } catch (\Exception $exception) {
                echo $exception->getMessage();
            }
            break;
    }
}

echo $car;
echo $truck;
echo $bus;