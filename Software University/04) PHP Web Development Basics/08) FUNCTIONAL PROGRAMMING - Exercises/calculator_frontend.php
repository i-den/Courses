<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="get">
    <div>
        <input name="firstNumber">
        <input name="secondNumber">
        <select name="operation">
            <option name="sum" value="sum">+</option>
            <option name="subtract" value="subtract">-</option>
            <option name="multiply" value="multiply">*</option>
            <option name="divide" value="divide">/</option>
        </select>
        <input type="submit" value="Go" name="Go">
    </div>
</form>
<br/>
<div>
    = <input name="result" value="<?= $result; ?>">
</div>
</body>
</html>
