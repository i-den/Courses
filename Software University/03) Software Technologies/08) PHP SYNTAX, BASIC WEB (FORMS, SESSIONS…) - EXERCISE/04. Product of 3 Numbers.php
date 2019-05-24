<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First Steps Into PHP</title>

</head>
<body>
    <form>
        X: <input type="text" name="num1" />
		Y: <input type="text" name="num2" />
        Z: <input type="text" name="num3" />
		<input type="submit" />
    </form>
    <?php
    if (isset($_GET['num1']) && isset($_GET['num2']) && isset($_GET['num3'])){
        $num1 = intval($_GET['num1']);
        $num2 = intval($_GET['num2']);
        $num3 = intval($_GET['num3']);
        $nums = [$num1, $num2, $num3];
        $positiveNums = 0;
        $negativeNums = 0;
        $isZero = false;
        $result = "";
        foreach ($nums as $num) {
            if ($num > 0){
                $positiveNums++;
            } else if ($num < 0) {
                $negativeNums++;
            } else if ($num == 0) {
                $isZero = true;
                break;
            }
        }

        if ($isZero == true || $negativeNums % 2 == 0) {
            $result = "Positive";
        } else {
            $result = "Negative";
        }

        echo $result;
    }
    ?>

	<!--Write your PHP Script here-->
</body>
</html>