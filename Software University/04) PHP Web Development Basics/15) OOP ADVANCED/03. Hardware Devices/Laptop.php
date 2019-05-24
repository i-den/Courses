<?php


namespace Van\Classes\Third;


class Laptop extends Computer implements IKeyboard, IMouse, ITouchScreen
{
    private $battery;

    public function __construct(
        string $processor,
        string $ram,
        int $battery
    )
    {
        $this->setBattery($battery);
        parent::__construct($processor, $ram);
    }

    /**
     * @return mixed
     */
    public function getBattery()
    {
        return $this->battery;
    }

    /**
     * @param mixed $battery
     * @return Laptop
     */
    public function setBattery($battery): Laptop
    {
        $this->battery = $battery;
        return $this;
    }

    public function pressKey()
    {
        echo 'Laptop\'s keyboard was pressed' . PHP_EOL;
    }

    public function changeStatus()
    {
        echo 'Laptop\'s status was changed' . PHP_EOL;
    }

    public function move()
    {
        echo 'Laptop\'s mouse was moved' . PHP_EOL;
    }

    public function moveFinger()
    {
        echo 'Moved finger across laptop\'s screen' . PHP_EOL;
    }

    public function clickFinger()
    {
        echo 'Clicked laptop\'s touchscreen' . PHP_EOL;
    }

    public function writeText()
    {
        echo 'Wrote text across laptop\'s touchscreen' . PHP_EOL;
    }
}