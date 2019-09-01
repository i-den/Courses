<?php

$productsQuantity = array();

while (true) {
    $stockProductQuantity = explode(' ', trim(fgets(STDIN)));

    if ($stockProductQuantity[0] === 'shopping') {
        break;
    }

    $currProduct = $stockProductQuantity[1];
    $currQuantity = intval($stockProductQuantity[2]);

    if (!isset($productsQuantity[$currProduct])) {
        $productsQuantity[$currProduct] = 0;
    }

    $productsQuantity[$currProduct] += $currQuantity;
}

while (true) {
    $demand = explode(' ', trim(fgets(STDIN)));

    if ($demand[0] === 'exam') {
        break;
    }

    $demandProduct = $demand[1];
    $demandQuantity = intval($demand[2]);

    if (!isset($productsQuantity[$demandProduct])) {
        echo $demandProduct . ' doesn\'t exist' . PHP_EOL;
    } else if ($productsQuantity[$demandProduct] === 0) {
        echo $demandProduct . ' out of stock' . PHP_EOL;
    } else {
        $remainingProductQuantity = $productsQuantity[$demandProduct] - $demandQuantity;

        $productsQuantity[$demandProduct] = $remainingProductQuantity > 0
            ? $remainingProductQuantity
            : 0;
    }
}

$productsQuantity = array_filter($productsQuantity, function ($quantity) {
   return $quantity > 0;
});

foreach ($productsQuantity as $product => $quantity) {
    echo $product . ' -> ' . $quantity . PHP_EOL;
}
