<?php


namespace Commands;


use Models\Citizen;
use Models\Robot;

class CreateCommand extends Command
{

    public function execute()
    {
        while (true) {
            $citizenInput = explode(' ', trim(fgets(STDIN)));
            $entityClassName = array_shift($citizenInput);

            if ($entityClassName == 'End') {
                break;
            } else if ($entityClassName == 'Robot') {
                continue;
            }
            $entityClassName = 'Models\\' . $entityClassName;
            $entity = new $entityClassName($citizenInput);
            $this->getCity()->addCitizen($entity);
        }
    }
}