<?php


namespace Models\Enhancements;


use Models\Ships\ShipAbstract;

class ExtendedFuelCells extends EnhancementsAbstract
{
    const ENH_EXT_FUEL_CELLS = 200;

    public function enhance(ShipAbstract $ship)
    {
        $ship->setFuel($ship->getFuel() + self::ENH_EXT_FUEL_CELLS);
    }
}