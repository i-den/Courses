<?php


namespace Van\Classes\First;


class Rectangle implements IArea
{
    private $width;
    private $height;

    public function __construct(float $width, float $height)
    {
        $this->setWidth($width)
            ->setHeight($height);
    }

    public function __toString()
    {
        $rectangleOutput =  'Rectangle, width = ' . $this->getWidth() . 'mm, height = ' . $this->getHeight() . 'mm, area = ' . $this->getSurface() . 'mm' . PHP_EOL;

        return $rectangleOutput;
    }

    public function getSurface(): float
    {
        return $this->getWidth() * $this->getWidth();
    }

    public function getWidth()
    {
        return $this->width;
    }

    public function setWidth($width): Rectangle
    {
        $this->width = $width;
        return $this;
    }

    public function getHeight()
    {
        return $this->height;
    }

    public function setHeight($height): Rectangle
    {
        $this->height = $height;
        return $this;
    }
}