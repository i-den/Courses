<?php


namespace Commands;


use Models\IBirthable;
use Models\Person;

class ListCommand extends Command
{

    public function execute()
    {
        $foodUnits = $this->getCity()->getFoodUnits();

        echo $foodUnits . ' units food' . PHP_EOL;
    }
}