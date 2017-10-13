<?php


namespace Van\Classes\Third;


class Tablet extends Mobile implements ITouchScreen
{
    private $stdResolution;

    public function __construct(
        string $operator,
        bool $canCall,
        int $battery,
        string $stdResolution
    )
    {
        $this->setStdResolution($stdResolution);
        parent::__construct($operator, $canCall, $battery);
    }

    public function getStdResolution()
    {
        return $this->stdResolution;
    }

    public function setStdResolution($stdResolution): Tablet
    {
        $this->stdResolution = $stdResolution;
        return $this;
    }

    public function moveFinger()
    {
        echo 'Moved finger across tablet\'s touchscreen' . PHP_EOL;
    }

    public function clickFinger()
    {
        echo 'Clicked finger on tablet\'s touchscreen' . PHP_EOL;
    }

    public function writeText()
    {
        echo 'Wrote text on tablet\'s touchscreen' . PHP_EOL;
    }
}