<?php


namespace App\Models;

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
     * @throws \Exception
     */
    public function setMake(string $make): Car
    {
        if (empty($make) || is_numeric($make)) {
            throw new \Exception('Invalid Car Make');
        }

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
     * @throws \Exception
     */
    public function setModel(string $model): Car
    {
        if (empty($model) || is_numeric($model)) {
            throw new \Exception('Invalid Car Model');
        }

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
     * @throws \Exception
     */
    public function setYear(int $year): Car
    {
        if ($year < 1886 || $year > date('Y')) {
            throw new \Exception('Invalid Year');
        }

        $this->year = $year;
        return $this;
    }
}
