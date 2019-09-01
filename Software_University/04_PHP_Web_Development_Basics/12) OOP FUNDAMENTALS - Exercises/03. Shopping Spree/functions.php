<?php

use Van\Classes\Third\Product;
use Van\Classes\Third\Person;

/**
 * @return Person[]
 */
function getPeopleFromInput(): array
{
    $people = array();

    $peopleInfo = preg_split('/;/', trim(fgets(STDIN)), NULL, PREG_SPLIT_NO_EMPTY);

    for ($i = 0; $i < count($peopleInfo); $i++) {
        $personInfo = explode('=', $peopleInfo[$i]);
        $name = $personInfo[0];
        $money = floatval($personInfo[1]);

        $people[] = new Person($name, $money);
    }

    return $people;
}

/**
 * @return Product[]
 */
function getProductsFromInput(): array
{
    $products = array();

    $productsInfo = preg_split('/;/', trim(fgets(STDIN)), NULL, PREG_SPLIT_NO_EMPTY);

    for ($i = 0; $i < count($productsInfo); $i++) {
        $productInfo = explode('=', $productsInfo[$i]);

        $name = $productInfo[0];
        $cost = floatval($productInfo[1]);

        $products[] = new Product($name, $cost);
    }

    return $products;
}

/**
 * @param Person[] $people
 * @param Product[] $products
 */
function shoppingSpree(array $people, array $products): void
{
    while (true) {
        $buyerProductInfo = explode(' ', trim(fgets(STDIN)));

        if ($buyerProductInfo[0] == 'END') {
            break;
        }

        $buyerName = $buyerProductInfo[0];
        $buyer = findObjectByName($people, $buyerName);
        $productName = $buyerProductInfo[1];
        $product = findObjectByName($products, $productName);

        if (!isset($buyer)) {
            exit('Not existing person');
        } else if (!isset($product)) {
            exit('Not existing product');
        }

        if ($buyer->canBuy($product)) {
            $buyer->buyProduct($product);
            echo $buyerName . ' bought ' . $productName . PHP_EOL;
        } else {
            echo $buyerName . ' can\'t afford ' . $productName . PHP_EOL;
        }
    }
}

/**
 * @param Person[] | Product[] $objects
 * @param string $name
 *
 * @return Person | Product | null
 */
function findObjectByName(array $objects, string $name)
{
    foreach ($objects as $object) {
        if ($object->getName() == $name) {
            return $object;
        }
    }

    return null;
}

/**
 * @param Person[] $people
 */
function displayPeopleProductInfo(array $people)
{
    foreach ($people as $person) {
        echo $person;
    }
}
