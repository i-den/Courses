<?php


namespace Van\Controllers;


abstract class Controller
{
    public function render($view, $data = array())
    {
        extract($data);
        $view = BASEDIR . '/app/Views/' . $view;

        require_once $view;
    }
}