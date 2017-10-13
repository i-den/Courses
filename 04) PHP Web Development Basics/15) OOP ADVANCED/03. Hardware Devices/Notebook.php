<?php


namespace Van\Classes\Third;


class Notebook extends Mobile implements IKeyboard, IMouse, ITouchScreen
{
    private $isTyping = false;
    private $writtenText = '';

    public function __construct($operator, $canCall, $battery)
    {
        parent::__construct($operator, $canCall, $battery);
    }

    public function pressKey()
    {
        echo 'Notebook\'s keyboard\'s key was pressed' . PHP_EOL;
    }

    public function changeStatus()
    {
        echo 'Notebook\'s status was changed' . PHP_EOL;
    }



    public function move()
    {
        echo 'Notebook\'s mouse was moved' . PHP_EOL;
    }

    public function moveFinger()
    {
        echo 'Finger was moved across notebook\'s touchscreen' . PHP_EOL;
    }

    public function clickFinger()
    {
        if (true === $this->isTyping) {
            echo 'Message sent' . PHP_EOL;
            $this->isTyping = false;
        } else {
            $this->isTyping = true;
            echo 'Clicked the Notebook\'s screen to start typing:' . PHP_EOL;
            $this->writeText();
        }
    }

    public function writeText()
    {
        $messageToSent = trim(fgets(STDIN));
        $this->writtenText .= $messageToSent . PHP_EOL;
        $this->clickFinger();
    }

    public function click($leftClick, $x, $y)
    {
        echo $leftClick
            ? 'Left'
            : 'Right';
        echo ' key was pressed with x: ' . $x . ' and y: ' . $y . PHP_EOL;
    }
}