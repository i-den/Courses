<!DOCTYPE html>
<?php
$num = "";
if(isset($_GET['num'])){
    $num = intval($_GET['num']);
    $num *= 2;
}
?>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" /><br/>
        <?php echo $num;?>
    </form>
</body>
</html>