<?php

$input = explode(' ', trim(fgets(STDIN)));
$id = $input[0];
$param_name = $input[1];
$param_value = $input[2];

$allowed_changes = array(
    'first_name', 'last_name', 'phone', 'home_address', 'is_active', 'motivation_letter', 'notes'
);

if (!in_array($param_name, $allowed_changes)) {
    exit('Not allowed param');
}

try {
    $db = new PDO('mysql:dbname=php-course;host=127.0.0.1', 'root', 'pass123');

    $query = $db->prepare("UPDATE `students` SET $param_name = :param_value WHERE `student_id` = :id");

    $query->bindParam('param_value', $param_value);
    $query->bindParam('id', $id);

    $query->execute();

} catch (PDOException $exception) {
    echo $exception->getMessage();
}
