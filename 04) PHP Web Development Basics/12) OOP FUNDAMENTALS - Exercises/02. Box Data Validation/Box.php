<?php

namespace Van\Classes\Second;


class Box
{
    private $length;
    private $width;
    private $height;

    public function __construct(float $length, float $width, float $height)
    {
        $this->setLength($length);
        $this->setWidth($width);
        $this->setHeight($height);
    }

    public function getSurfaceArea(): string
    {
        $surface = (
            (2 * $this->length * $this->height)
            + (2 * $this->length * $this->width)
            + (2 * $this->width * $this->height)
        );

        return number_format(round($surface, 2), 2);
    }

    public function getVolume(): string
    {
        $volume = $this->length * $this->width * $this->height;

        return number_format(round($volume, 2), 2);
    }

    public function getLateralSurfaceArea(): string
    {
        $latteralSurfaceArea = (2 * $this->length * $this->height) + (2 * $this->width * $this->height);

        return number_format(round($latteralSurfaceArea, 2), 2);
    }

    /**
     * @param float $length
     */
    private function setLength(float $length)
    {
        if ($length <= 0) {
            exit('Length cannot be zero or negative.');
        }

        $this->length = $length;
    }

    /**
     * @param float $width
     */
    private function setWidth(float $width)
    {
        if ($width <= 0) {
            exit('Width cannot be zero or negative.');
        }

        $this->width = $width;
    }

    /**
     * @param float $height
     */
    private function setHeight(float $height)
    {
        if ($height <= 0) {
            exit('Height cannot be zero or negative.');
        }

        $this->height = $height;
    }
}
