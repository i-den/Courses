<?php

$amountOfPeople = intval(fgets(STDIN));
$package = trim(fgets(STDIN));

$hallPrices = array(
    'Small Hall' => 2500,
    'Terrace' => 5000,
    'Great Hall' => 7500
);

$packagePrices = array(
    'Normal' => array(
        'Discount' => 5,
        'Price' => 500
    ),
    'Gold' => array(
        'Discount' => 10,
        'Price' => 750
    ),
    'Platinum' => array(
        'Discount' => 15,
        'Price' => 1000
    )
);

$suitableHall = '';

if ($amountOfPeople > 120) {
    echo 'We do not have an appropriate hall';
    exit;
} else if ($amountOfPeople <= 50) {
    $suitableHall = 'Small Hall';
} else if ($amountOfPeople > 50 && $amountOfPeople <= 100) {
    $suitableHall = 'Terrace';
} else if ($amountOfPeople > 100 && $amountOfPeople <= 120) {
    $suitableHall = 'Great Hall';
}

$fullPrice = $hallPrices[$suitableHall] + $packagePrices[$package]['Price'];
$discountedPrice = $fullPrice * ((100 - $packagePrices[$package]['Discount']) / 100);

$pricePerPerson = round(($discountedPrice / $amountOfPeople), 2);

echo "We can offer you the $suitableHall\n";
echo "The price per person is $pricePerPerson\$";
