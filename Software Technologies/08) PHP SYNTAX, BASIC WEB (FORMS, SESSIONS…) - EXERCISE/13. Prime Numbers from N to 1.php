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
        $primeNumbers = [2, 3];

        for ($i = 2; $i <= $num; $i++) {
            $isPrime = true;

            for ($j = 2; $j <= sqrt($num); $j++) {
                if ($i % $j == 0) {
                    $isPrime = false;
                    break;
                }
            }

            if ($isPrime) {
                $primeNumbers[] = $i;
            }
        }

        $primeNumbers = array_reverse($primeNumbers);

        echo implode(" ", $primeNumbers);
    }
    ?>
	<!--Write your PHP Script here-->
</body>
</html>