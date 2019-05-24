<?php

namespace Van\Classes\Third;


class DesktopComputer extends Computer implements IKeyboard, IMouse
{
    private $keyboardConnected = false;

    public function __construct($processor, $ram, $keyboardConnected)
    {
        $this->setKeyboardConnected($keyboardConnected);
        parent::__construct($processor, $ram);
    }

    public function pressKey()
    {
       echo 'Computer\'s keyboard was pressed' . PHP_EOL;
    }

    public function changeStatus()
    {
        echo 'Computer\'s keyboard\'s status was changed' . PHP_EOL;
    }

    public function move()
    {
        echo 'Computer\'s mouse was moved' . PHP_EOL;
    }

    public function isKeyboardConnected(): bool
    {
        return $this->keyboardConnected;
    }

    public function setKeyboardConnected(bool $keyboardConnected): DesktopComputer
    {
        $this->keyboardConnected = $keyboardConnected;
        return $this;
    }
}