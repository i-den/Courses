<?php

namespace Vehicles;


interface VehicleInterface
{
    public function drive(float $distance);

    public function refuel(float $fuel);
}
