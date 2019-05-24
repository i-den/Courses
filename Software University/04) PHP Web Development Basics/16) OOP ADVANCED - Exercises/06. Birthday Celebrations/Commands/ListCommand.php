<?php


namespace Commands;


use Models\IBirthable;
use Models\Person;

class ListCommand extends Command
{

    public function execute()
    {
        $yearToBeBornIn = trim(fgets(STDIN));
        $livingThingsToList = $this->getCity()->getLivingThingsBornIn($yearToBeBornIn);

        if (empty($livingThingsToList)) {
            exit('<no output>');
        }

        /** @var Person | IBirthable $citizen */
        foreach ($livingThingsToList as $citizen) {
            echo $citizen->getBirthday() . PHP_EOL;
        }
    }
}