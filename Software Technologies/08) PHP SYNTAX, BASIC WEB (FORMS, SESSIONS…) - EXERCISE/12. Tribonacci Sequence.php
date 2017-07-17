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
        $tribonacciNumbers = [1, 1, 2];
        $firstNum = 1;
        $secNum = 1;
        $thirdNum = 2;

        for ($i = 3; $i < $num; $i++) {
            $tribonacciNumbers[$i] = $firstNum + $secNum + $thirdNum;
            $thirdNum = $tribonacciNumbers[$i];
            $secNum = $tribonacciNumbers[$i - 1];
            $firstNum = $tribonacciNumbers[$i - 2];
        }

        echo implode(" ", $tribonacciNumbers);
    }
    ?>
	<!--Write your PHP Script here-->
</body>
</html>