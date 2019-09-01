<?php

class SimpleOperator
{
    /**
     * @var int
     */
    private $firstNumber;

    /**
     * @var int
     */
    private $secondNumber;

    public function __construct(int $firstNumber, int $secondNumber)
    {
        $this->firstNumber = $firstNumber;
        $this->secondNumber = $secondNumber;
    }

    function sum(): int
    {
        return $this->firstNumber + $this->secondNumber;
    }

    function divide(): float
    {
        if ($this->firstNumber === 0 || $this->secondNumber === 0) {
            echo 'division by zero is not possible';
        }

        return $this->firstNumber / $this->secondNumber;
    }

    /**
     * @return int
     */
    public function getFirstNumber(): int
    {
        return $this->firstNumber;
    }

    /**
     * @param int $firstNumber
     */
    public function setFirstNumber(int $firstNumber)
    {
        $this->firstNumber = $firstNumber;
    }

    /**
     * @return int
     */
    public function getSecondNumber(): int
    {
        return $this->secondNumber;
    }

    /**
     * @param int $secondNumber
     */
    public function setSecondNumber(int $secondNumber)
    {
        $this->secondNumber = $secondNumber;
    }
}

$firstOperator = new SimpleOperator(2, 3);
$secondOperator = new SimpleOperator(1, 2);

echo $firstOperator->sum() . PHP_EOL;
echo $secondOperator->divide() . PHP_EOL;

