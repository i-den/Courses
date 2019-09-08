<?php declare(strict_types=1);

$message = "";
if (isset($_GET['cel'])){
    $cel = floatval($_GET['cel']);
    $fah = celToFah($cel);
    $message = "$cel &deg;C = $fah &deg;F";
} else if (isset($_GET['fah'])){
    $fah = floatval($_GET['fah']);
    $cel = fahToCel($fah);
    $message = "$fah &deg;F = $cel &deg;C";
};

function fahToCel(float $fahrenheit) : float
{
    return ($fahrenheit - 32) / 1.8;
}

function celToFah(float $celsius) : float
{
    return $celsius * 1.8 + 32;
}
?>

<form>
    Celsius: <input type="number" name="cel"/>
    <input type="submit" value="Convert">
    <?php if (isset($_GET['cel'])){
        echo $message;
    }?>
</form>
<form>
    Fahrenheit: <input type="number" name="fah"/>
    <input type="submit" value="Convert">
    <?php if (isset($_GET['fah'])){
        echo $message;
    }?>
</form>