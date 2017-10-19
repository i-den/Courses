<?php

$student_count = intval(trim(fgets(STDIN)));

for ($i = 0; $i < $student_count; $i++) {
    $student_info = explode(' ', trim(fgets(STDIN)));
    $first_name = $student_info[0];
    $last_name = $student_info[1];
    $student_number = $student_info[2];
    $phone = null;
    if (count($student_info) > 3) {
        $phone = $student_info[3];
    }
    try {
        $db = new PDO('mysql:dbname=php-course;host=127.0.0.1', 'root', 'pass123');

        $statement = $db->prepare("INSERT INTO `php-course`.`students` (`first_name`, `last_name`, `student_number`, `phone`) VALUES (?, ?, ?, ?)");

        $statement->bindParam(1, $first_name);
        $statement->bindParam(2, $last_name);
        $statement->bindParam(3, $student_number);
        $statement->bindParam(4, $phone);

        $statement->execute();

    } catch (PDOException $exception) {
        echo $exception->getMessage();
    }
}


