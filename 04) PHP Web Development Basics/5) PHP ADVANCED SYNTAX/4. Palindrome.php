<?php

$input = trim(fgets(STDIN));

echo isPalindrome($input)
    ? 'true'
    : 'false';

function isPalindrome($stringToCheck)
{
    $strLen = strlen($stringToCheck);
    for ($i = 0; $i < $strLen / 2; $i++) {
        $firstChar = $stringToCheck[$i];
        $lastChar = $stringToCheck[$strLen - $i - 1];

        if ($firstChar !== $lastChar) {
            return false;
        }
    }

    return true;
}
