<?php

$cookingNumber = floatval(trim(fgets(STDIN)));
$commands = explode(', ', trim(fgets(STDIN)));

foreach ($commands as $command) {
    switch ($command) {
        case 'chop':
            $cookingNumber /= 2;
            break;
        case 'dice':
            $cookingNumber = sqrt($cookingNumber);
            break;
        case 'spice':
            $cookingNumber += 1;
            break;
        case 'bake':
            $cookingNumber *= 3;
            break;
        case 'fillet':
            $cookingNumber *= 0.8;
            break;
    }

    echo $cookingNumber . PHP_EOL;
}
