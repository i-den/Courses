<?php

namespace Van\Classes\Third;


abstract class Mobile
{
    private $operator;
    private $canCall;
    private $battery;

    public function __construct(string $operator, bool $canCall, int $battery)
    {
        $this->setOperator($operator)
            ->setCanCall($canCall)
            ->setBattery($battery);
    }

    public function getOperator()
    {
        return $this->operator;
    }

    public function setOperator($operator): Mobile
    {
        $this->operator = $operator;
        return $this;
    }

    public function getCanCall()
    {
        return $this->canCall;
    }

    public function setCanCall($canCall): Mobile
    {
        $this->canCall = $canCall;
        return $this;
    }

    public function getBattery()
    {
        return $this->battery;
    }

    public function setBattery($battery): Mobile
    {
        $this->battery = $battery;
        return $this;
    }
}