<?php


namespace Models;

/**
 * Class Car
 * @package Models
 */
class Car
{
    /** @var  string */
    private $make;
    /** @var  string */
    private $model;
    /** @var  int */
    private $year;

    public function __construct(string $make, string $model, int $year)
    {
        $this->setMake($make)
            ->setModel($model)
            ->setYear($year);
    }

    /**
     * @return string
     */
    public function getMake(): string
    {
        return $this->make;
    }

    /**
     * @param   string  $make
     * @return  Car
     */
    public function setMake(string $make): Car
    {
        $this->make = $make;
        return $this;
    }

    /**
     * @return string
     */
    public function getModel(): string
    {
        return $this->model;
    }

    /**
     * @param   string  $model
     * @return  Car
     */
    public function setModel(string $model): Car
    {
        $this->model = $model;
        return $this;
    }

    /**
     * @return int
     */
    public function getYear(): int
    {
        return $this->year;
    }

    /**
     * @param   int     $year
     * @return  Car
     */
    public function setYear(int $year): Car
    {
        $this->year = $year;
        return $this;
    }
}
