<?php

use Core\Request\Request;
use Core\Router\Router;

/**
 * Loads the Database settings
 */
require_once __DIR__ . '/../../config.php';

/**
 * Auto-loading
 */
require_once BASEDIR . '/vendor/autoload.php';

/**
 * Initialize the Router
 */
$router = new Router();

/**
 * Includes the Header
 */
include_once BASEDIR . '/app/Views/Partials/header.php';

/**
 * Tries to route depending on the Request, including the corresponding Body
 */
try {

    $router->direct(Request::getURI(), Request::getMethod());

} catch (Exception $exception) {

    $error = $exception->getMessage();
    include_once BASEDIR . '/app/Views/Messages/error.php';

}

/**
 * Includes the Footer
 */
include_once BASEDIR . '/app/Views/Partials/footer.php';

