<?php

namespace Van\Classes;

class Cargo
{
    /**
     * @var int
     */
    private $weight;

    /**
     * @var string
     */
    private $type;

    /**
     * Cargo constructor.
     *
     * @param int $weight
     * @param string $type
     */
    public function __construct(int $weight, string $type)
    {
        $this->weight = $weight;
        $this->type = $type;
    }

    /**
     * @return int
     */
    public function getWeight(): int
    {
        return $this->weight;
    }

    /**
     * @param int $weight
     */
    public function setWeight(int $weight)
    {
        $this->weight = $weight;
    }

    /**
     * @return string
     */
    public function getType(): string
    {
        return $this->type;
    }

    /**
     * @param string $type
     */
    public function setType(string $type)
    {
        $this->type = $type;
    }
}