<?php

/**
 * If under Windows make sure to comment 7th row out
 */
spl_autoload_register(function ($class) {
    $classFile = str_replace('\\', '/', $class) . '.php';
    require_once $classFile;
});
