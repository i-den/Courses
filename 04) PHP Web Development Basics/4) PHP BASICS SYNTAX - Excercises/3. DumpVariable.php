<?php

$tests = array('hello', 15, 1.234, array(1, 2, 3), (object)[2, 34]);

for ($i = 0; $i < count($tests); $i++) {
    if (is_numeric($tests[$i])) {
        var_dump($tests[$i]);
    } else {
        echo gettype($tests[$i]) . "\n";
    }
}