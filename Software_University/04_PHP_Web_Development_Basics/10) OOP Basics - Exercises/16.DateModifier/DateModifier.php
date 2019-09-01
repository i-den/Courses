<?php

namespace Van\ClassesC;

use \DateTime;

class DateModifier
{
    /**
     * @var string
     */
    private $startDate;

    /**
     * @var string
     */
    private $endDate;

    /**
     * @var string
     */
    private $dayDifference;

    /**
     * DateModifier constructor.
     *
     * @param string $startDate
     * @param string $endDate
     */
    public function __construct(string $startDate, string $endDate)
    {
        $this->startDate = str_replace(' ', '-', $startDate);
        $this->endDate = str_replace(' ', '-', $endDate);
    }

    /**
     * Returns the difference between the two start/end Date
     * properties in a string
     *
     * @return string
     */
    private function calculatesDiff(): string
    {
        $startDay = new DateTime($this->startDate);
        $endDay = new DateTime($this->endDate);

        $differenceInDays = $startDay->diff($endDay);
        $this->dayDifference = $differenceInDays->format('%a');

        return $this->dayDifference;
    }

    public function __toString()
    {
        $this->calculatesDiff();
        return $this->dayDifference . PHP_EOL;
    }
}