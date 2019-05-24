<?php

namespace Van\Classes\Third;


abstract class Computer
{
    protected $processor;
    protected $ram;

    public function __construct(string $processor, int $ram)
    {
        $this->setProcessor($processor)
            ->setRam($ram);
    }

    public function getProcessor()
    {
        return $this->processor;
    }

    public function setProcessor(string $processor): Computer
    {
        $this->processor = $processor;
        return $this;
    }

    public function getRam()
    {
        return $this->ram;
    }

    public function setRam(int $ram): Computer
    {
        $this->ram = $ram;
        return $this;
    }

    public function click($leftClick, $x, $y)
    {
        echo $leftClick
            ? 'Left'
            : 'Right';
        echo ' key was pressed with x: ' . $x . ' and y: ' . $y . PHP_EOL;
    }
}