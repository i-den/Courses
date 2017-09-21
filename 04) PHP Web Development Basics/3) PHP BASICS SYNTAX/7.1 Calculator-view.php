<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculate Two Numbers</title>
</head>
<body>
<style>
    #form {
        border: 1px solid black;
        -webkit-border-radius:;
        -moz-border-radius:;
        border-radius: 3px;
        margin: 0 30%;
        text-align: center;
    }
</style>
<form method="get">
    <div id="form">
        <div>
            <label for="operation">Operation:</label>
            <select id="operation" name="operation">
                <option value="sum">Sum</option>
                <option value="subtract">Subtract</option>
            </select>
        </div>
        <div>
            <label for="number_one">Number 1:</label>
            <input id="number_one" type="number" name="number_one">
        </div>
        <div>
            <label for="number_two">Number 2:</label>
            <input id="number_two" type="number" name="number_two">
        </div>
        <div>
            <input type="submit" name="calculate" value="Calculate!">
        </div>
        <?php if (isset($result)) : ?>
            <div>Your result is <?php echo $result ?> </div>
        <?php endif; ?>
    </div>
</form>

</body>
</html>
