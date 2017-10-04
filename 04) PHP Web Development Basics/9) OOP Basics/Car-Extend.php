<?php

namespace Van\Classes;

use Van\Classes\CarExtraDetails;

include './CarExtraDetails.php';

class Car
{
    /**
     * @var string
     */
    private $brand;

    /**
     * @var string
     */
    private $model;

    /**
     * @var int
     */
    private $year;

    /**
     * @var CarExtraDetails
     */
    private $extraDetails;

    public function __construct(
        string $brand,
        string $model,
        string $engine,
        int $numberOfSeats,
        int $horsepower
    )
    {
        $this->brand = $brand;
        $this->model = $model;

        $extraDetails = new CarExtraDetails($engine, $numberOfSeats, $horsepower);
        $this->extraDetails = $extraDetails;
    }

    public function printStats(): void
    {
        echo $this->brand . ',' . $this->model . ',' . $this->year . PHP_EOL;
    }

    /**
     * @return string
     */
    public function getBrand(): string
    {
        return $this->brand;
    }

    /**
     * @param string $brand
     */
    public function setBrand(string $brand)
    {
        $this->brand = $brand;
    }

    /**
     * @return string
     */
    public function getModel(): string
    {
        return $this->model;
    }

    /**
     * @param string $model
     */
    public function setModel(string $model)
    {
        $this->model = $model;
    }

    /**
     * @return int
     */
    public function getYear()
    {
        return $this->year;
    }

    /**
     * @param int $year
     */
    public function setYear(int $year)
    {
        if (is_numeric($year) && strlen($year) === 4) {
            $this->year = $year;
        }
    }
}
