<?php

spl_autoload_register(function($className) {
    $classFile = str_replace('\\', DIRECTORY_SEPARATOR, $className) . '.php';
    require_once __DIR__ . DIRECTORY_SEPARATOR . $classFile;
});

$arr = [
    '' => '',
    '' => '',
    '' => '',
    '' => '',
    '' => '',
    '' => '',
    '' => '',
];

$binder = new \Core\DataBinder();
//$object = $binder->bind($arr, );
//var_dump($object);