<?php

$students = array('Ivan', 'Georgi', 'Teodor', 'Maria', 'Petya');
$studentNames = array_keys($students);

echo '<ul>';
for ($i = 0; $i < count($students); $i++) {
    $currentIndice = $studentNames[$i];
    echo '<li>' . $students[$currentIndice] . '</li>';
}
echo '</ul>';

echo '<pre>' , print_r($students) , '</pre>';