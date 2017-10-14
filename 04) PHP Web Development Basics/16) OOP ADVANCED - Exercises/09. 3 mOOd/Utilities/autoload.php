<?php

spl_autoload_register(function ($class) {
   $classFile = $class . '.php';
   require_once $classFile;
});
