<?php

namespace Van\Classes;

use Van\Classes\Engine;
use Van\Classes\Cargo;
use Van\Classes\Tire;

include './Engine.php';
include './Cargo.php';
include './Tire.php';

class Car
{
    /**
     * @var string
     */
    private $model;

    /**
     * @var Engine
     */
    private $engine;

    /**
     * @var Cargo
     */
    private $cargo;

    /**
     * @var array
     */
    private $tires;

    public function __construct(
        string $model,
        int $engineSpeed,
        int $enginePower,
        int $cargoWeight,
        string $cargoType,
        float $firstTirePressure,
        int $firstTireAge,
        float $secondTirePressure,
        int $secondTireAge,
        float $thirdTirePressure,
        int $thirdTireAge,
        float $fourthTirePressure,
        int $fourthTireAge
    )
    {
        $this->model = $model;
        $this->engine = new Engine($engineSpeed, $enginePower);
        $this->cargo = new Cargo($cargoWeight, $cargoType);

        $frontLeftTire = new Tire($firstTireAge, $firstTirePressure);
        $frontRightTire = new Tire($secondTireAge, $secondTirePressure);
        $backLeftTire = new Tire($thirdTireAge, $thirdTirePressure);
        $backRightTire = new Tire($fourthTireAge, $fourthTirePressure);

        $this->tires = array(
            'frontLeft' => $frontLeftTire,
            'frontRight' => $frontRightTire,
            'backLeft' => $backLeftTire,
            'backRight' => $backRightTire
        );
    }

    /**
     * Checks if the Cargo instance's Type is equal to $type
     *
     * @param string $type
     * @return bool
     */
    public function isCargoType(string $type)
    {
        return $this->cargo->getType() === $type;
    }

    /**
     * Checks if any of the Tire instances property has a Pressure property below $maxTirePressure
     *
     * @param int $maxTirePressure
     * @return bool
     */
    public function hasTirePressureOfLessThan(int $maxTirePressure)
    {
        foreach ($this->tires as $tirePosition => $tireInstance) {
            if ($tireInstance->getPressure() < $maxTirePressure) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the Engine instance's Power protery is above the $minEnginePower
     *
     * @param int $minEnginePower
     * @return bool
     */
    public function hasEnginePowerOfMoreThan(int $minEnginePower)
    {
        return $this->engine->getPower() > $minEnginePower;
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
}