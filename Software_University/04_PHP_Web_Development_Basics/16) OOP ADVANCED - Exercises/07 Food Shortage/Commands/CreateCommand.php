<?php


namespace Commands;


use Models\Citizen;
use Models\Rebel;
use Models\Robot;

class CreateCommand extends Command
{

    public function execute()
    {
        $personCount = intval(trim(fgets(STDIN)));

        for ($i = 0; $i < $personCount; $i++) {
            $personInfo = explode(' ', trim(fgets(STDIN)));
            $className = 'Models\\';
            if (count($personInfo) == 3) {
                $className .= 'Rebel';
                $class = new $className($personInfo);
                $this->getCity()->addPerson($class);
            } else {
                $className .= 'Citizen';
                $class = new $className($personInfo);
                $this->getCity()->addPerson($class);
            }
        }
    }
}