<?php

namespace Van\Classes;

class DecimalNumber
{
    /**
     * @var string
     */
    private $numberStr;

    /**
     * DecimalNumber constructor.
     *
     * @param string $numberStr
     */
    public function __construct(string $numberStr)
    {
        $this->numberStr = $numberStr;
    }

    /**
     * @return string
     */
    public function getReversedString() : string
    {
        return  strrev($this->numberStr);
    }
}
