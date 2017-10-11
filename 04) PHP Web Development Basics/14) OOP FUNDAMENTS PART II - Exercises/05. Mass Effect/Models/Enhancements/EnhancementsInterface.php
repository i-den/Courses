<?php


namespace Models\Enhancements;


use Models\Ships\ShipAbstract;

interface EnhancementsInterface
{
    public function enhance(ShipAbstract $ship);
}