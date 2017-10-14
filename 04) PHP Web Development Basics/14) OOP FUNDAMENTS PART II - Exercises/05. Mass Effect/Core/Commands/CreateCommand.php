<?php


namespace Core\Commands;


class CreateCommand extends Command
{

    public function execute(array $createArgs)
    {
        $type = array_shift($createArgs);
        $name = array_shift($createArgs);

        if ($this->getGalaxy()->hasStarShip($name)) {
            throw new \Exception('Ship with such name already exists' . PHP_EOL);
        }

        $starSystemName = array_shift($createArgs);
        $starSystem = $this->getGalaxy()->getStarSystem($starSystemName);
        $enhancements = $createArgs;

        $className = 'Models\\Ships\\' . $type;

        $shipToCreate = new $className(
            $type,
            $name,
            $starSystem,
            $this->getGalaxy(),
            $enhancements
        );

        $starSystem->addShip($shipToCreate);
        $this->getGalaxy()->addStarShip($name);
    }
}