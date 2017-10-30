<?php


namespace Core\Router;


class Router
{
    private $routes = array();

    public function __construct()
    {
        $this->routes = array(

            'GET' => array(
                ''      => 'HomeController@home',
                'cats/list'  => 'CatController@list',
                'cats/new'  => 'CatController@getAddCat',
                'cats/edit' => 'CatController@getEditCat'
            ),

            'POST' => array(
                'cats/new'  => 'CatController@insertCat',
                'cats/edit' => 'CatController@editCat'
            )
        );
    }

    public function direct(string $uri, string $requestType)
    {
        if (!array_key_exists($uri, $this->routes[$requestType])) {
            throw new \Exception('Route not found!');

        }

        $this->callAction(...explode('@', $this->routes[$requestType][$uri]));
    }

    protected function callAction($controller, $action)
    {
        $controller = 'Van\\Controllers\\' . $controller;
        $controller = new $controller();

        if (!method_exists($controller, $action)) {
            throw new \Exception('No such method in the controller');
        }

        $controller->$action();
    }
}