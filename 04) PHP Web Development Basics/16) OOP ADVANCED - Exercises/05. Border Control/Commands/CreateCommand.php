<?php


namespace Commands;


use Models\Human;
use Models\Robot;

class CreateCommand extends Command
{

    public function execute()
    {
        while (true) {
            $citizenInput = explode(' ', trim(fgets(STDIN)));
            $name = $citizenInput[0];

            if ($name == 'End') {
                break;
            }

            if (count($citizenInput) == 2) {
                $id = $citizenInput[1];
                $this->getCity()->addCitizen(new Robot($id, $name));
            } else {
                $age = intval($citizenInput[1]);
                $id = $citizenInput[2];
                $this->getCity()->addCitizen(new Human($id, $name, $age));
            }
        }
    }
}