<?php
if (isset($_GET['number_one'], $_GET['number_two'], $_GET['operation'], $_GET['calculate'])
    && !empty($_GET['number_one'])
    && !empty($_GET['number_two'])
) {
    $numberOne = intval($_GET['number_one']);
    $numberTwo = intval($_GET['number_two']);
    $result = '';

    switch ($_GET['operation']) {
        case 'sum':
            $result = $numberOne + $numberTwo;
            break;
        case 'subtract':
            $result = $numberOne - $numberTwo;
            break;
        default:
            $result = 'Invalid operation';
            break;
    }
}

include '7.1 Calculator-view.php';