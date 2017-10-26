<?php


namespace Service;


use Core\Database\FakeDoctrine;
use Models\Course;
use Models\Student;

class Application
{
    /**
     * @var FakeDoctrine
     */
    private $database;

    public function __construct(FakeDoctrine $database)
    {
        $this->setDatabase($database);
    }

    /**
     * Takes input from the STDIN and
     * tries to insert Students in the
     * database
     */
    public function start()
    {
        while (true) {
            $studentInput   = explode(' ', trim(fgets(STDIN)));

            if ($studentInput[0] == 'end') {
                break;
            }

            if (count($studentInput) < 4) {
                echo 'Invalid Input, try again' . PHP_EOL;
                continue;
            }

            $firstName      = array_shift($studentInput);
            $lastName       = array_shift($studentInput);
            $studentNumber  = intval(array_shift($studentInput));
            $courseName     = implode(' ', $studentInput);

            $course     = new Course($courseName);

            $student    = new Student(
                $firstName,
                $lastName,
                $studentNumber,
                $course
            );

            try {
                $this->getDatabase()->insertStudent($student);
            } catch (\Exception $e) {
                echo $e->getMessage() . PHP_EOL;
                continue;
            }
        }

        $this->getDatabase()->listAllStudents();
    }

    /**
     * @return FakeDoctrine
     */
    public function getDatabase(): FakeDoctrine
    {
        return $this->database;
    }

    /**
     * @param FakeDoctrine $database
     * @return Application
     */
    public function setDatabase(FakeDoctrine $database): Application
    {
        $this->database = $database;
        return $this;
    }
}