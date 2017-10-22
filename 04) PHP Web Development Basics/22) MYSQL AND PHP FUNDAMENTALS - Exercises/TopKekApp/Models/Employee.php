<?php

namespace Models;


class Employee
{
    private $firstName;
    private $middleName;
    private $lastName;
    private $department;
    private $position;
    private $passportId;

    public function __construct(
        string $firstName,
        string $middleName,
        string $lastName,
        string $department,
        string $position,
        string $passportId
    )
    {
        $this->setFirstName($firstName)
            ->setMiddleName($middleName)
            ->setLastName($lastName)
            ->setDepartment($department)
            ->setPosition($position)
            ->setPassportId($passportId);
    }

    /**
     * @return string
     */
    public function getFirstName(): string
    {
        return $this->firstName;
    }

    /**
     * @param string $firstName
     * @return Employee
     */
    public function setFirstName($firstName): Employee
    {
        $this->firstName = $firstName;
        return $this;
    }

    /**
     * @return string
     */
    public function getMiddleName(): string
    {
        return $this->middleName;
    }

    /**
     * @param string $middleName
     * @return Employee
     */
    public function setMiddleName($middleName): Employee
    {
        $this->middleName = $middleName;
        return $this;
    }

    /**
     * @return string
     */
    public function getLastName(): string
    {
        return $this->lastName;
    }

    /**
     * @param string $lastName
     * @return Employee
     */
    public function setLastName($lastName): Employee
    {
        $this->lastName = $lastName;
        return $this;
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
     * @return Employee
     */
    public function setDepartment($department): Employee
    {
        $this->department = $department;
        return $this;
    }

    /**
     * @return string
     */
    public function getPosition(): string
    {
        return $this->position;
    }

    /**
     * @param string $position
     * @return Employee
     */
    public function setPosition($position): Employee
    {
        $this->position = $position;
        return $this;
    }

    /**
     * @return string
     */
    public function getPassportId(): string
    {
        return $this->passportId;
    }

    /**
     * @param string $passportId
     * @return Employee
     */
    public function setPassportId($passportId): Employee
    {
        $this->passportId = $passportId;
        return $this;
    }

}