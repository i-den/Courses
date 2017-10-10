<?php


namespace Van\FourthClasses;


class Car extends Vehicle
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
     * Car constructor.
     *
     * @param int $numberDoors
     * @param string $color
     * @param string $brand
     * @param string $model
     * @param int $year
     */
    public function __construct(
        int $numberDoors,
        string $color,
        string $brand,
        string $model,
        int $year
    )
    {
        parent::__construct($numberDoors, $color);

        $this->setBrand($brand);
        $this->setModel($model);
        $this->setYear($year);
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
