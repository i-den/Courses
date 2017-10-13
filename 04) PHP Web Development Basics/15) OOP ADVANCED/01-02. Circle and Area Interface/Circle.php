<?php


namespace Van\Classes\First;


class Circle implements IArea, \ICircumference
{
    /** @var  float */
    private $radius;

    public function __construct(float $radius)
    {
        $this->setRadius($radius);
    }

    public function __toString()
    {
        $circleOutput  = 'Circle with radius = ' . $this->getRadius() . 'mm:' . PHP_EOL;
        $circleOutput .= 'Area = ' . $this->getSurface() . 'mm' . PHP_EOL;
        $circleOutput .= 'Circumference = ' . $this->getCircumference() . 'mm' . PHP_EOL;

        return $circleOutput;
    }

    public function getSurface()
    {
        return pow($this->radius, 2) * pi();
    }

    public function getCircumference(): float
    {
        return 2 * pi() * $this->getRadius();
    }

    private function getRadius(): float
    {
        return $this->radius;
    }

    private function setRadius($radius): Circle
    {
        $this->radius = $radius;
        return $this;
    }
}