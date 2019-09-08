<?php

$begin = new DateTime('first day of this month');
$end = new DateTime('last day of this month');

$thisMonth = $begin->format('F');
$thisYear = $begin->format('Y');

for ($i = $begin; $i < $end; $i->modify('+1 day')) {
    if ($i->format('D') == 'Sun') {
        $thisDay = $i->format('jS');
        echo "$thisDay $thisMonth, $thisYear\n";
    }
}
