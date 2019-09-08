<?php

require_once './Person.php';
require_once './Product.php';
require_once './functions.php';

$people = getPeopleFromInput();
$products = getProductsFromInput();

shoppingSpree($people, $products);

displayPeopleProductInfo($people);
