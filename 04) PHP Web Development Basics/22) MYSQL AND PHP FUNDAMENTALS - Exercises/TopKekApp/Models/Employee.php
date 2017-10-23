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
    /**
     * @var Email[]
     */
    private $emails = array();
    /**
     * @var
     */
    private $phones = array();

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

    public function __toString()
    {
        $employeeOutput  = 'First Name: ' . $this->getFirstName() . PHP_EOL;
        $employeeOutput .= 'Middle Name: ' . $this->getMiddleName() . PHP_EOL;
        $employeeOutput .= 'Last Name: ' . $this->getLastName() . PHP_EOL;
        $employeeOutput .= 'Department: ' . $this->getDepartment() . PHP_EOL;
        $employeeOutput .= 'Position: ' . $this->getPosition() . PHP_EOL;
        $employeeOutput .= 'Passport ID: ' . $this->getPassportId() . PHP_EOL;

        if (!empty($this->getEmails())) {
            $employeeOutput .= 'Emails:' . PHP_EOL;

            /** @var Email[] $workEmails */
            $workEmails = array_filter($this->getEmails(), function (Email $email){
               return $email->getType() == 'Work';
            });

            /** @var Email[] $personalEmails */
            $personalEmails = array_filter($this->getEmails(), function (Email $email) {
               return $email->getType() == 'Personal';
            });

            if (!empty($workEmails)) {
                $employeeOutput .= '-Work:' . PHP_EOL;
                foreach ($workEmails as $workEmail) {
                    $employeeOutput .= $workEmail->getAddress() . PHP_EOL;
                }
            }

            if (!empty($personalEmails)) {
                $employeeOutput .= 'Personal:' . PHP_EOL;
                foreach ($personalEmails as $personalEmail) {
                    $employeeOutput .= $personalEmail->getAddress() . PHP_EOL;
                }
            }

        } else {
            $employeeOutput .= 'No Emails' . PHP_EOL;
        }

        if (!empty($this->getPhones())) {
            $employeeOutput .= 'Phones:' . PHP_EOL;

            /** @var Phone[] $workPhones */
            $workPhones = array_filter($this->getPhones(), function(Phone $phone) {
               return $phone->getType() == 'Work';
            });

            /** @var Phone[] $personalPhones */
            $personalPhones = array_filter($this->getPhones(), function(Phone $phone) {
               return $phone->getType() == 'Personal';
            });

            if (!empty($workPhones)) {
                $employeeOutput .= '-Work:' . PHP_EOL;
                foreach ($workPhones as $workPhone) {
                    $employeeOutput .= $workPhone->getNumber() . PHP_EOL;
                }
            }

            if (!empty($personalPhones)) {
                $employeeOutput .= 'Personal:' . PHP_EOL;
                foreach ($personalPhones as $personalPhone) {
                    $employeeOutput .= $personalPhone->getNumber() . PHP_EOL;
                }
            }
        }

        return $employeeOutput;
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

    /**
     * @param Email $email
     */
    public function addEmail(Email $email)
    {
        $this->emails[] = $email;
    }

    /**
     * @return Email[]
     */
    public function getEmails(): array
    {
        return $this->emails;
    }

    /**
     * @param Phone $phone
     */
    public function addPhone(Phone $phone)
    {
        $this->phones[] = $phone;
    }

    /**
     * @return Phone[]
     */
    public function getPhones(): array
    {
        return $this->phones;
    }
}
