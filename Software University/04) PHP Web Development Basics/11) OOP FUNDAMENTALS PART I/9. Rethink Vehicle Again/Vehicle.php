<?php

namespace Van\NinthClass;


class Vehicle
{
    /**
     * @var string
     */
    protected $brand;

    /**
     * @var string
     */
    protected $model;

    /** @var  string */
    protected $color;

    /**
     * @var int
     */
    protected $year;

    /**
     * Vehicle constructor.
     *
     * @param string $brand
     * @param string $model
     * @param string $color
     * @param int $year
     */
    protected function __construct(
        string $brand,
        string $model,
        string $color,
        int $year
    )
    {
        $this->setBrand($brand);
        $this->setModel($model);
        $this->setColor($color);
        $this->setYear($year);
    }

    /**
     * @return string
     */
    private function getBrand(): string
    {
        return $this->brand;
    }

    /**
     * @param string $brand
     */
    private function setBrand(string $brand)
    {
        $this->brand = $brand;
    }

    /**
     * @return string
     */
    private function getModel(): string
    {
        return $this->model;
    }

    /**
     * @param string $model
     */
    private function setModel(string $model)
    {
        $this->model = $model;
    }

    /**
     * @return string
     */
    private function getColor(): string
    {
        return $this->color;
    }

    /**
     * @param string $color
     */
    private function setColor(string $color)
    {
        $this->color = $color;
    }

    /**
     * @return int
     */
    public function getYear(): int
    {
        return $this->year;
    }

    /**
     * @param int $year
     */
    public function setYear(int $year)
    {
        $this->year = $year;
    }
}
