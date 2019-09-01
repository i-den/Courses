<?php


namespace Models;


class Phone
{
    /** @var  string */
    private $number;

    /** @var  string */
    private $type;

    /**
     * Phone constructor.
     * @param string $number
     * @param string $type
     */
    public function __construct($number, $type)
    {
        $this->setNumber($number)
            ->setType($type);
    }

    /**
     * @return string
     */
    public function getNumber(): string
    {
        return $this->number;
    }

    /**
     * @param string $number
     * @return Phone
     */
    public function setNumber(string $number): Phone
    {
        $this->number = $number;
        return $this;
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
     * @return Phone
     */
    public function setType(string $type): Phone
    {
        $this->type = $type;
        return $this;
    }
}
