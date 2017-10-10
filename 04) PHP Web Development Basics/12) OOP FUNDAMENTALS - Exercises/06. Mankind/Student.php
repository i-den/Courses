<?php


namespace Van\Classes\Sixth;


class Student extends Human
{
    /** @var  int */
    private $facultyNumber;

    public function __construct(string $firstName, string $lastName, int $facultyNumber)
    {
        parent::__construct($firstName, $lastName);
        $this->setFacultyNumber($facultyNumber);
    }

    public function __toString()
    {
        $studentOutput  = 'First Name: ' . $this->getFirstName() . PHP_EOL;
        $studentOutput .= 'Last Name: ' . $this->getLastname() . PHP_EOL;
        $studentOutput .= 'Faculty Number: ' . $this->facultyNumber . PHP_EOL . PHP_EOL;

        return $studentOutput;
    }

    private function setFacultyNumber(int $facultyNumber): Student
    {
        $numberLength = (string)$facultyNumber;
        if (($numberLength > 5 && $numberLength < 10)) {
            throw new \Exception('Invalid faculty number!');
        }

        $this->facultyNumber = $facultyNumber;

        return $this;
    }
}