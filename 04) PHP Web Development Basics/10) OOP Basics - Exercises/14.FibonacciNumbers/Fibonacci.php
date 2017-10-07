<?php

namespace Van\Classes;

class Fibonacci
{
    /**
     * @var array
     */
    private $fibonacciSequence;

    /**
     * @var int
     */
    private $startingNumber;

    /**
     * @var int
     */
    private $endingNumber;

    /**
     * Fibonacci constructor.
     *
     * @param int $startIndex
     * @param int $endIndex
     */
    public function __construct(int $startIndex, int $endIndex)
    {
        $this->startingNumber = $startIndex;
        $this->endingNumber = $endIndex;
        $this->fibonacciSequence = array(0, 1);
    }

    /**
     * @return array
     */
    private function fibonacciRange(): array
    {
        for ($i = 2; $i < $this->endingNumber; $i++) {
            $firstNum = $this->fibonacciSequence[$i - 2];
            $secNum = $this->fibonacciSequence[$i - 1];
            $this->fibonacciSequence[] = $firstNum + $secNum;
        }

        return $this->fibonacciSequence =
            array_slice($this->fibonacciSequence, $this->startingNumber, $this->endingNumber);
    }

    /**
     * @return array
     */
    public function getFibonacciSequence(): array
    {
        $this->fibonacciRange();
        return $this->fibonacciSequence;
    }
}
