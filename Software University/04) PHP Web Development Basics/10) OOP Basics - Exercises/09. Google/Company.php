<?php

namespace Van\ClassesA;

class Company
{
    /**
     * @var string
     */
    private $name;

    /**
     * @var string
     */
    private $department;

    /**
     * @var float
     */
    private $salary;

    /**
     * Company constructor.
     *
     * @param string $name
     * @param string $department
     * @param float $salary
     */
    public function __construct(string $name, string $department, float $salary)
    {
        $this->name = $name;
        $this->department = $department;
        $this->salary = $salary;
    }

    /**
     * @return string
     */
    public function getName(): string
    {
        return $this->name;
    }

    /**
     * @param string $name
     */
    public function setName(string $name)
    {
        $this->name = $name;
    }

    /**
     * @return string
     */
    public function getDepartment(): string
    {
        return $this->department;
    }

    /**
     * @param string $department
     */
    public function setDepartment(string $department)
    {
        $this->department = $department;
    }

    /**
     * @return float
     */
    public function getSalary(): float
    {
        return number_format($this->salary, 2);
    }

    /**
     * @param float $salary
     */
    public function setSalary(float $salary)
    {
        $this->salary = $salary;
    }
}
