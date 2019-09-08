<?php


namespace Models;


class Student
{
    /** @var  string */
    private $firstName;
    /** @var  string */
    private $lastName;
    /** @var  int */
    private $studentNumber;

    /** @var  Course[] */
    private $courses;

    public function __construct(
        string $firstName,
        string $lastName,
        int $studentNumber,
        $course
    )
    {
        $this->setFirstName($firstName)
            ->setLastName($lastName)
            ->setStudentNumber($studentNumber)
            ->addCourse($course);
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
     * @return Student
     */
    public function setFirstName(string $firstName): Student
    {
        $this->firstName = $firstName;
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
     * @return Student
     */
    public function setLastName(string $lastName): Student
    {
        $this->lastName = $lastName;
        return $this;
    }

    /**
     * @return int
     */
    public function getStudentNumber(): int
    {
        return $this->studentNumber;
    }

    /**
     * @param int $studentNumber
     * @return Student
     */
    public function setStudentNumber(int $studentNumber): Student
    {
        $this->studentNumber = $studentNumber;
        return $this;
    }

    /**
     * @return Course[]
     */
    public function getCourses(): array
    {
        return $this->courses;
    }

    /**
     * @param Course $course
     * @return Student
     */
    public function addCourse(Course $course): Student
    {
        $this->courses[] = $course;
        return $this;
    }
}