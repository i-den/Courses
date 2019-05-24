<?php

/**
 * If under Windows uncomment first row and comment out the second
 */
spl_autoload_register(function ($class) {
    //$class = $class . '.php';
    $class = BASEDIR . '/' .str_replace('\\', '/', $class) . '.php';
    require_once $class;
});
