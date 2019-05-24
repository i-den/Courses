<?php

if (isset($_GET['filter'], $_GET['delimiter'], $_GET['names'], $_GET['ages'])
    && !empty($_GET['delimiter'])
    && !empty($_GET['names'])
    && !empty($_GET['ages'])
) {
    $allowedDelimiters = array('|', ',', '&');

    $delimiter = $_GET['delimiter'];
    $formNames = $_GET['names'];
    $formAges = $_GET['ages'];

    if (!in_array($delimiter, $allowedDelimiters)) {
        $error = 'Wrong delimiter';
    } else if (strpos($formNames, $delimiter) === false
        && strpos($formAges, $delimiter) === false
    ) {
        $error = 'No delimiters found mate';
    }

    if (!empty($error)) {
        header("Location: 10._Almost_Working_Pagination_xD?error=$error");
        exit;
    }

    $names = explode($delimiter, $formNames);
    $ages = array_map('intval', explode($delimiter, $formAges));

    if (count($names) !== count($ages)) {
        $error = "There should be an age for each name and vise versa, Kev";
        header("Location: 10._Almost_Working_Pagination_xD?error=$error");
        exit;
    }

    $students = filterArrayAges($names, $ages);

    $resultsPerPage = 5;
    $page = 1;

    if (isset($_GET['page'])) {
        $page = $_GET['page'];
    }

    $startIndex = ($page - 1) * $resultsPerPage;
    $endIndex = $startIndex + $resultsPerPage;
    $totalPages = ceil(count($names) / $resultsPerPage);

    $hasPrevious = $page > 1;
    $hasNext = $page < $totalPages;

    $queryString = $_SERVER['QUERY_STRING'];
    $queryString = preg_replace("/page=\d+&/", "", $queryString);

    $start = 0;
    $studentsPaged = array();

    foreach ($students as $name => $age) {
        if ($start >= $startIndex && $start < $endIndex) {
            $studentsPaged[$name] = $age;
        }

        $start++;
    }
}

function filterArrayAges($firstArray, $secondArray)
{
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

include '10._Almost_Working_Pagination_xD-View.php';