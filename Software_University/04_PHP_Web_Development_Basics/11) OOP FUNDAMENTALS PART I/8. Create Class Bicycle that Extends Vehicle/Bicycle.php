<?php


namespace Van\EightClass;


class Bicycle extends Vehicle
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
     * @var bool
     */
    private $forSkirt;

    /**
     * @var bool
     */
    private $isRidden = null;

    public function __construct(
        string $color,
        string $brand,
        string $model,
        int $year
    )
    {
        parent::setColor($color);

        $this->setDoors();
        $this->setBrand($brand);
        $this->setModel($model);
        $this->setYear($year);
        $this->forSkirt = false;
        $this->isRidden = false;
    }

    public function __toString()
    {
        return
            "<div>
                <table>
                  <tr>
                    <th>Number of Doors</th>
                    <th>Color</th>
                    <th>Brand</th>
                    <th>Model</th>
                    <th>Year</th>
                    <th>Suitable For Skirts</th>
                    <th>Is Currently In Use</th>
                  </tr>  
                  <tr>
                    <td>" . parent::getNumberDoors() . "</td>
                    <td>" . parent::getColor() . "</td>
                    <td>" . $this->brand . "</td>
                    <td>" . $this->model . "</td>
                    <td>" . $this->year . "</td>
                    <td>" . $this->forSkirt ? "yes" : "no" . "</td>
                    <td>" . $this->isRidden ? "yes" : "no" . "</td>
                  </tr>
                </table>
            </div>";
    }

    public function ride(): void
    {
        $this->isRidden = true;
    }

    public function stop(): void
    {
        $this->isRidden = false;
    }

    private function setDoors(): void
    {
        $this->setNumberDoors(0);
    }

    /**
     * @return mixed
     */
    public function getBrand(): string
    {
        return $this->brand;
    }

    /**
     * @param mixed $brand
     */
    public function setBrand($brand)
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

    /**
     * @return mixed
     */
    public function getForSkirt()
    {
        return $this->forSkirt;
    }

    /**
     * @param mixed $forSkirt
     */
    public function setForSkirt($forSkirt)
    {
        $this->forSkirt = $forSkirt;
    }

    /**
     * @return mixed
     */
    public function getisRidden()
    {
        return $this->isRidden;
    }

    /**
     * @param mixed $isRidden
     */
    public function setIsRidden($isRidden)
    {
        $this->isRidden = $isRidden;
    }
}