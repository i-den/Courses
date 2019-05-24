<?php


namespace Core\Database;


use Models\Course;
use Models\Student;


/**
 * Class FakeDoctrine
 *
 * Simple class Extending \PDO
 * Basically, just \PDO without requiring args
 * and containing all database interactions
 *
 * @package Core\Database
 */
class FakeDoctrine extends \PDO
{
    const DB_HOST = 'localhost';
    const DB_NAME = 'php-course';
    const DB_USER = 'root';
    const DB_PASS = 'pass123';

    public function __construct()
    {
        $dsn = 'mysql:host=' . self::DB_HOST . ';dbname=' . self::DB_NAME . ';charset=utf8';
        parent::__construct(
            $dsn,
            self::DB_USER,
            self::DB_PASS,
            array(
                \PDO::ATTR_ERRMODE => \PDO::ERRMODE_EXCEPTION
            )
        );
    }

    public function insertStudent(Student $student)
    {
        $courses = $student->getCourses();
        /** @var Course $course */
        $course = end($courses);
        $courseName = $course->getName();
        $courseId = $this->courseExists($courseName);

        if ($courseId == null) {
            throw new \Exception('Course doesn\'t exist!' . PHP_EOL);
        }

        $this->beginTransaction();

        $studentQuery = $this->prepare(
            "INSERT INTO `students` (`first_name`, `last_name`, `student_number`)
                      VALUES (?, ?, ?)"
        );

        $studentCourseQuery = $this->prepare(
            "INSERT INTO `student_subscriptions` (course_id, student_id)
                      VALUES(?, ?)"
        );

        try {

            $studentQuery->execute(array(
                $student->getFirstName(),
                $student->getLastName(),
                $student->getStudentNumber()
            ));

            $studentCourseQuery->execute(array(
                    $courseId,
                    $this->lastInsertId())
            );

            $this->commit();

        } catch (\PDOException $e) {

            $this->rollBack();

            echo $e->getMessage() . PHP_EOL;

        }
    }

    private function courseExists(string $name)
    {
        $stmt = $this->prepare(
            "SELECT  `course_id`
                      FROM    `courses`
                      WHERE   course_name = ?
                      LIMIT 1"
        );

        if ($stmt->execute(array($name))) {
            $row = $stmt->fetch(\PDO::FETCH_ASSOC);
            return $row['course_id'];
        }

        return null;
    }

    public function listAllStudents()
    {
        $this->query(
            "CALL listAllStudents();"
        );
    }
}
