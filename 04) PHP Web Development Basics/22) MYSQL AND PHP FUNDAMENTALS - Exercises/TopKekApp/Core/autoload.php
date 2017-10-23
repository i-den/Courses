<?php

spl_autoload_register(function ($class) {
    // Comment out if under Windows
    $classFile = str_replace('\\', '/', $class) . '.php';
    require_once $classFile;
});
