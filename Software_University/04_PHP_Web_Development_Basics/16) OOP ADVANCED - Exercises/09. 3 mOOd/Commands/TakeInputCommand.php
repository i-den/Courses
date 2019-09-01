<?php


namespace Commands;


class TakeInputCommand extends Command
{

    public function execute()
    {
        $characterInfo = explode(' | ', trim(fgets(STDIN)));

        $name = $characterInfo[0];
        $classType = 'Models\\' . $characterInfo[1];
        $specialPoints = floatval($characterInfo[2]);
        $level = intval($characterInfo[3]);

        $character = new $classType($name, $specialPoints, $level);
        $this->getGame()->addCharacter($character);
    }
}