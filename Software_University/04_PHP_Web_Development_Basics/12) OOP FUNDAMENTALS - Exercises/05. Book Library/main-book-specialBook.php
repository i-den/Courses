<?php

declare(strict_types=1);

require_once './Book.php';
require_once './SpecialBook.php';

use Van\Classes\Fifth\Book;
use Van\Classes\Fifth\SpecialBook;

$author = trim(fgets(STDIN));
$title = trim(fgets(STDIN));
$price = floatval(trim(fgets(STDIN)));
$edition = trim(fgets(STDIN));

switch ($edition) {
    case 'STANDARD':
        echo new Book($title, $author, $price);
        break;
    case 'GOLD':
        echo new SpecialBook($title, $author, $price);
        break;
    default:
        throw new Exception('Type is not valid!');
        break;
}
