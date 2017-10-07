<?php

namespace Van\Classes;

class Number
{
    /**
     * @var int
     */
    private $number;

    /**
     * @var string
     */
    private $digitName;

    /**
     * Number constructor.
     *
     * @param int $number
     */
    public function __construct(int $number)
    {
        $this->number = $number;
    }

    /**
     * @return string
     */
    public function getLastDigitAsChar(): string
    {
        $this->number %= 10;

        switch ($this->number) {
            case 0:
                $this->digitName = 'zero';
                break;
            case 1:
                $this->digitName = 'one';
                break;
            case 2:
                $this->digitName = 'two';
                break;
            case 3:
                $this->digitName = 'three';
                break;
            case 4:
                $this->digitName = 'four';
                break;
            case 5:
                $this->digitName = 'five';
                break;
            case 6:
                $this->digitName = 'six';
                break;
            case 7:
                $this->digitName = 'seven';
                break;
            case 8:
                $this->digitName = 'eight';
                break;
            case 9:
                $this->digitName = 'nine';
                break;
        }

        return $this->digitName;
    }
}