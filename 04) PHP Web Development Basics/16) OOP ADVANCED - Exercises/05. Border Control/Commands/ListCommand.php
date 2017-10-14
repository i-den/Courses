<?php


namespace Commands;


use Models\Person;

class ListCommand extends Command
{

    public function execute()
    {
        /** @var Person $citizen */
        foreach ($this->getCity()->getDetainedCitizen() as $citizen) {
            echo $citizen->getId() . PHP_EOL;
        }
    }
}