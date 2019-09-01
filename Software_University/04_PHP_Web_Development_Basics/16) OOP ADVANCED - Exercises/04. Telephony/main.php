<?php

spl_autoload_register(function ($class) {
    $className = __DIR__ . '\\' . $class . '.php';
    require_once $className;
});

$phone = new Phone();

$phoneNumbersToCall = explode(' ', trim(fgets(STDIN)));
$urlsToBrowse = explode(' ', trim(fgets(STDIN)));

for ($i = 0; $i < count($phoneNumbersToCall); $i++) {
    try {
        $phone->callPhone($phoneNumbersToCall[$i]);
    } catch (Exception $exception) {
        echo $exception->getMessage();
    }
}

for ($i = 0; $i < count($urlsToBrowse); $i++) {
    try {
        $phone->browseInternet($urlsToBrowse[$i]);
    } catch (Exception $exception) {
        echo $exception->getMessage();
    }
}
