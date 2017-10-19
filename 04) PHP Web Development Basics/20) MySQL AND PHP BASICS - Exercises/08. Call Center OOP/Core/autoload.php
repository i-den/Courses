<?php

spl_autoload_register(function ($class) {
   $classFile = str_replace('\\', '/', $class) . '.php';
   require_once $classFile;
});
