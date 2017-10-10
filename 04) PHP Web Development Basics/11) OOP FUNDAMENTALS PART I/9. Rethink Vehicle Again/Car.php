<?php


namespace Van\NinthClass;


class Car extends Vehicle
{
    /**
     * @var int
     */
    private $doorCount;

    /**
     * Car constructor.
     *
     * @param string $brand
     * @param string $model
     * @param string $color
     * @param int $year
     * @param int $doorCount
     */
    public function __construct(
        string $brand,
        string $model,
        string $color,
        int $year,
        int $doorCount
    )
    {
        parent::__construct($brand, $model, $color, $year);

        $this->setDoorCount($doorCount);
    }

    /**
     * @return int
     */
    public function getDoorCount(): int
    {
        return $this->doorCount;
    }

    /**
     * @param int $doorCount
     */
    public function setDoorCount(int $doorCount)
    {
        $this->doorCount = $doorCount;
    }
}
