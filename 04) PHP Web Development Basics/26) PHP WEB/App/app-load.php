<?php


use App\Service\CarShop;


//define('BASEDIR', substr(__DIR__, 0, strrpos(__DIR__, '/')));
define('BASEDIR', '/home/van/public_html/denchev.com');
define('HOST', $_SERVER['HTTP_HOST']);

/**
 * Auto-loading via spl_autoload_register
 */
require_once BASEDIR . '/Core/autoload.php';

/**
 * Load Global config settings
 * - Database Settings
 */
require_once BASEDIR . '/App/config.php';

/**
 * Initialize the Application
 */
$carShopApp = new CarShop();
$carShopApp->serve();
