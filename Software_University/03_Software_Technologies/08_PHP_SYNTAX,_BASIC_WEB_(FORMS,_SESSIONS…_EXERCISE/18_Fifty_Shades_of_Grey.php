<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>
    <style>
        div {
            display: inline-block;
            margin: 5px;
            width: 20px;
            height: 20px;
        }
    </style> 
</head>
<body>
<?php
$color = 0;

for ($i = 0; $i < 5; $i++) {
    $innerColor = $color;
    for ($j = 0; $j < 10; $j++) {
        echo "<div style='background-color: rgb($innerColor, $innerColor, $innerColor);'></div>";
        $innerColor += 5;
    }

    $color += 51;
    echo "<br/>";
}
?>
</body>
</html>