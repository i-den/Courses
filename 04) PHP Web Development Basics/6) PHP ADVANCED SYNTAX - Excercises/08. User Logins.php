<?php

$usersPasswordsList = array();
$failedLoginAttempts = 0;

while (true) {
    $input = explode(' -> ', trim(fgets(STDIN)));

    if ($input[0] === 'login') {
        break;
    }

    $user = $input[0];
    $password = $input[1];

    $usersPasswordsList[$user] = $password;
}

while (true) {
    $input = explode(' -> ', trim(fgets(STDIN)));

    if ($input[0] === 'end') {
        break;
    }

    $user = $input[0];
    $password = $input[1];

    if (isset($usersPasswordsList[$user])
        && $usersPasswordsList[$user] === $password
    ) {
        echo $user . ': logged in successfully' . PHP_EOL;
    } else {
        echo $user . ': login failed' . PHP_EOL;
        $failedLoginAttempts++;
    }
}

echo 'unsuccessful login attempts: ' .$failedLoginAttempts . PHP_EOL;
