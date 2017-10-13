<?php


namespace Van\Classes\Third;


class Phone implements ITouchScreen
{
    private $size;

    public function __construct(int $size)
    {
        $this->setSize($size);
    }

    public function moveFinger()
    {
        echo 'Moved finger across Phone\'s touchscreen' . PHP_EOL;
    }

    public function clickFinger()
    {
        echo 'Clicked on the Phone\'s screen' . PHP_EOL;
    }

    public function writeText()
    {
        echo 'Wrote text on the Phone\'s screen' . PHP_EOL;
    }

    public function getSize()
    {
        return $this->size;
    }

    /**
     * @param mixed $size
     * @return Phone
     */
    public function setSize($size): Phone
    {
        $this->size = $size;
        return $this;
    }
}