<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
    <form>
        N: <input type="text" name="num" />
        <input type="submit" />
    </form>
    <?php
    if (isset($_GET['num'])) {
        $num = intval($_GET['num']);
        $fibonacciNumbers = [1, 1];
        $num1 = 1;
        $num2 = 1;

        for ($i = 2; $i < $num; $i++) {
            $fibonacciNumbers[] = $num1 + $num2;
            $num1 = $fibonacciNumbers[$i - 1];
            $num2 = $fibonacciNumbers[$i];
        }

        echo implode(" ", $fibonacciNumbers);
    }
    ?>
	<!--Write your PHP Script here-->
</body>
</html>