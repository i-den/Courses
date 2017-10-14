<?php


namespace Van\Classes\Third;


class Ferrari implements ICar
{
    private $model;
    private $driver;

    private static $objNum;

    public function __construct(string $model, string $driver)
    {
        $this->setModel($model)
            ->setDriver($driver);

        self::$objNum++;
    }

    public function __toString()
    {
        $ferrariOutput = $this->getModel() . '/' . $this->useBrakes()
            . '/' . $this->pushGashPedal() . '/' . $this->getDriver()
            . ' inst. ' . self::$objNum . PHP_EOL;

        return $ferrariOutput;
    }

    public static function forUrl(string $str, string $rep = '-')
    {
        return strtolower(str_replace(' ', $rep, $str));
    }

    public function useBrakes(): string
    {
        return 'Brakes!';
    }

    public function pushGashPedal(): string
    {
        return 'Zadu6avam sA!';
    }

    public function getModel()
    {
        return $this->model;
    }

    public function setModel($model): Ferrari
    {
        $this->model = $model;
        return $this;
    }

    public function getDriver()
    {
        return $this->driver;
    }

    public function setDriver($driver): Ferrari
    {
        $this->driver = $driver;
        return $this;
    }
}