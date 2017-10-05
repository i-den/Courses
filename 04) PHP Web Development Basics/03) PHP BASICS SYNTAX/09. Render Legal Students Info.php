<?php

if (isset($_GET['filter'], $_GET['delimiter'], $_GET['names'], $_GET['ages'])
    && !empty($_GET['delimiter'])
    && !empty($_GET['names'])
    && !empty($_GET['ages'])
) {
    $delimiter = $_GET['delimiter'];
    $formNames = $_GET['names'];
    $formAges = $_GET['ages'];

    if (!strpos($formNames, $delimiter) !== false
        && !strpos($formAges, $delimiter) !== false
    ) {
        $errorMessage = "No delimiters found mate..";
    } else {
        $names = explode($delimiter, $formNames);
        $ages = array_map('intval', explode($delimiter, $formAges));

        if (count($names) == count($ages)) {
            $students = filterArrayAges($names, $ages);
        } else {
            $errorMessage = "There should be an age for each name and vise versa, Kev..";
        }
    }
}

function filterArrayAges($firstArray, $secondArray) {
    $resultsArray = array();

    for ($i = 0; $i < count($firstArray); $i++) {
        $key = $firstArray[$i];
        $value = $secondArray[$i];

        if ($value >= 18) {
            $resultsArray[$key] = $value;
        }
    }

    return $resultsArray;
}

include '9.1. Render Legal Students Info-View.php';