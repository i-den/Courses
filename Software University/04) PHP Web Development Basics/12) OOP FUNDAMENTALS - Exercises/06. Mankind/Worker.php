<?php


namespace Van\Classes\Sixth;


class Worker extends Human
{
    /** @var  float */
    private $weekSalary;

    /** @var  int */
    private $workHoursPerDay;

    public function __construct(
        string $firstName,
        string $lastName,
        float $weekSalary,
        int $workHoursPerDay
    )
    {
        parent::__construct($firstName, $lastName);
        $this->setWeekSalary($weekSalary)
            ->setWorkHoursPerDay($workHoursPerDay);
    }

    public function __toString()
    {
        $workerOutput  = 'First Name: '      . $this->getFirstName()           . PHP_EOL;
        $workerOutput .= 'Last Name: '       . $this->getLastname()            . PHP_EOL;
        $workerOutput .= 'Week Salary: '     . $this->getWeekSalary()          . PHP_EOL;
        $workerOutput .= 'Hours per day: '   . $this->getWorkHoursPerDay()     . PHP_EOL;
        $workerOutput .= 'Salary per hour: ' . $this->calculateSalaryPerHour() . PHP_EOL;

        return $workerOutput;
    }

    protected function setLastName(string $lastName): Human
    {
        if (strlen($lastName) < 3) {
            throw new \Exception('"Expected length more than 3 symbols!Argument: lastName"');
        }

        return parent::setLastName($lastName);
    }

    protected function setWeekSalary(float $weekSalary): Worker
    {
        if ($weekSalary < 10) {
            throw new \Exception('"Expected value mismatch!Argument: weekSalary"');
        }

        $this->weekSalary = $weekSalary;

        return $this;
    }

    protected function getWeekSalary(): string
    {
        return number_format($this->weekSalary, 2, '.', '');
    }

    protected function setWorkHoursPerDay(int $workHoursPerDay): Worker
    {
        if ($workHoursPerDay > 12 || $workHoursPerDay < 1) {
            throw new \Exception('"Expected value mismatch!Argument: workHoursPerDay"');
        }

        $this->workHoursPerDay = $workHoursPerDay;

        return $this;
    }

    protected function getWorkHoursPerDay(): int
    {
        return $this->workHoursPerDay;
    }

    protected function calculateSalaryPerHour(): float
    {
        $salaryPerHour = ($this->weekSalary / ($this->workHoursPerDay * 7));
        return number_format(round($salaryPerHour, PHP_ROUND_HALF_DOWN), 2);
    }
}