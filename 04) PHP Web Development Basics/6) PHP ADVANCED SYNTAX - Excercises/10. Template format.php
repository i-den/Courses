<?php

$quiz = explode(', ', trim(fgets(STDIN)));

printXmlHeader();
for ($i = 0; $i < count($quiz); $i += 2) {
    $question = $quiz[$i];
    $answer = $quiz[$i + 1];

    printQuestion($question);
    printAnswer($answer);
}
echo '</quiz>' . PHP_EOL;

function printXmlHeader()
{
    echo '<?xml version="1.0" encoding="UTF-8"?>' . PHP_EOL;
    echo '<quiz>' . PHP_EOL;
}

function printQuestion(string $question)
{
    echo '  <question>' . PHP_EOL;
    echo '    ' . $question . PHP_EOL;
    echo '  </question>' . PHP_EOL;
}

function printAnswer(string $answer)
{
    echo '  <answer>' . PHP_EOL;
    echo '    ' .$answer . PHP_EOL;
    echo '  </answer>' . PHP_EOL;
}
