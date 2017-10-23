<?php
/**
 * @author Denchev07
 * https://softuni.bg/users/profile/show/denchev07
 *
 * GitHub i-den
 * https://github.com/i-den/SoftwareUniversity
 *
 * TopKekApp
 * Best HR Software for stupid p*tki
 *
 */

/**
 * Kogato iskash da si
 * Java ili C#
 */
declare(strict_types=1);


use Core\Adapter\TotallyDoctrine;
use Core\Service\TopKekSoft;

/**
 * Require autoloading via
 * spl_autoload_register()
 */
require_once './Core/autoload.php';

$database = new TotallyDoctrine();

$topKekSoft = new TopKekSoft($database);

$topKekSoft->start();
