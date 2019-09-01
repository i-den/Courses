<?php
// eb*h ti maikata
$inputPts = array_map('floatval', explode(', ', trim(fgets(STDIN))));

// Pts array holding x and y axis for each point
$pts = array(
    array(
        'x' => $inputPts[0],
        'y' => $inputPts[1]
    ),
    array(
        'x' => $inputPts[2],
        'y' => $inputPts[3]
    ),
    array(
        'x' => $inputPts[4],
        'y' => $inputPts[5]
    )
);

// distances array that will hold the distance between pts 1-2, 1-3, 2-3
$distances = array();
$distanceIndice = 0;

for ($i = 0; $i < count($pts); $i++) {
    $firstX = $pts[$i]['x'];
    $firstY = $pts[$i]['y'];

    for ($j = $i + 1; $j < count($pts); $j++) {
        $secondX = $pts[$j]['x'];
        $secondY = $pts[$j]['y'];

        $first = $i + 1;
        $second = $j + 1;
        $distanceName = $first . '<=>' . $second;
        $distanceValue = distanceBetweenTwoPts($firstX, $firstY, $secondX, $secondY);

        $distances[$distanceIndice] = array();
        $distances[$distanceIndice]['name'] = $distanceName;
        $distances[$distanceIndice]['value'] = $distanceValue;
        $distanceIndice++;
    }
}

// puts the longest path between points on top
usort($distances, function($a, $b) {
   $valueCmp = $b['value'] <=> $a['value'];
   if ($valueCmp === 0) {
       return strcmp($b['name'], $a['name']);
   }
   return $valueCmp;
});

// longs path (i.e 1-3) won't be used so the distance will be 1-2-3, i.e put 2 in between
$path = array_map('floatval', explode('<=>', $distances[0]['name']));
$midElement = 6 - array_sum($path);
$sum = $distances[1]['value'] + $distances[2]['value'];

$path = $path[0] . '->' . $midElement . '->' . $path[1] . ': ' . $sum . PHP_EOL;

echo $path;

function distanceBetweenTwoPts($x1, $y1, $x2, $y2): float
{
    $sideX = pow(($x1 - $x2), 2);
    $sideY = pow(($y1 - $y2), 2);
    $sumSides = $sideX + $sideY;

    return sqrt($sumSides);
}
