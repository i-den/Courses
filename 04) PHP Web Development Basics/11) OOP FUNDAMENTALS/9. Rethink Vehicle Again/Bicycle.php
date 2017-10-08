<?php


namespace Van\NinthClass;


class Bicycle extends Vehicle
{
    /**
     * @var bool
     */
    private $forSkirt;

    /**
     * @var bool
     */
    private $isRidden;

    /**
     * Bicycle constructor.
     *
     * @param string $brand
     * @param string $model
     * @param string $color
     * @param int $year
     */
    public function __construct(
        string $brand,
        string $model,
        string $color,
        int $year
    )
    {
        parent::__construct($brand, $model, $color, $year);

        $this->setForSkirt(false);
        $this->setIsRidden(false);
    }

    public function ride(): void
    {
        $this->isRidden = true;
    }

    public function stop(): void
    {
        $this->isRidden = false;
    }

    /**
     * @return bool
     */
    public function getForSkirt(): bool
    {
        return $this->forSkirt;
    }

    /**
     * @param mixed $forSkirt
     */
    public function setForSkirt(bool $forSkirt)
    {
        $this->forSkirt = $forSkirt;
    }

    /**
     * @return mixed
     */
    public function getisRidden(): bool
    {
        return $this->isRidden;
    }

    /**
     * @param mixed $isRidden
     */
    public function setIsRidden(bool $isRidden)
    {
        $this->isRidden = $isRidden;
    }
}
