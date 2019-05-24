<?php

namespace Van\Classes\First;


class Box
{
    private $length;
    private $width;
    private $height;

    public function __construct(float $length, float $width, float $height)
    {
        $this->length = $length;
        $this->width = $width;
        $this->height = $height;
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
}
