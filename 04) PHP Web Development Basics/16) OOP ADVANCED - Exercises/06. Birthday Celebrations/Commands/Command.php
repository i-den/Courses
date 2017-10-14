<?php


namespace Commands;


use Core\City;

abstract class Command implements IExecutable
{
    protected $city;

    public function __construct(City $city)
    {
        $this->setCity($city);
    }

    public function getCity(): City
    {
        return $this->city;
    }

    public function setCity($city): Command
    {
        $this->city = $city;
        return $this;
    }
}