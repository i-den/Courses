<?php

$delete_id = trim(fgets(STDIN));


try {

    $db = new PDO('mysql:dbname=php-course;host=127.0.0.1', 'root', 'pass123');

    $stmt = $db->prepare("DELETE FROM `students` WHERE `student_id` = :id");

    $stmt->bindParam('id', $delete_id);
    $stmt->execute();

} catch (PDOException $exception) {
    echo $exception->getMessage();
}
