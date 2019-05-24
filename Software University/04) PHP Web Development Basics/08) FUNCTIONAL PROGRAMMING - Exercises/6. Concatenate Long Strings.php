<?php
declare(strict_types=1);

$above = 20;

$input = [
    'Hello ',
    'there.',
    'This is just another long string',
    'that would pass the check.',
    ' but',
    ' this',
    ' will',
    ' not',
    'pass it.'
];

$output = filterArray($input, function ($currStringInArr) use ($above) {
    return strlen($currStringInArr) > $above;
});

echo $output . PHP_EOL;

function filterArray(array $array, callable $callback)
{
    $output = '';
    foreach ($array as $currStringInArr) {
        if ($callback($currStringInArr)) {
            $output .= $currStringInArr;
        }
    }
    return $output;
}