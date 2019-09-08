<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="get">
    <div>
        <label>
            Delimiter:
            <select name="delimiter">
                <option value=",">,</option>
                <option value="|">|</option>
                <option value="&">&amp;</option>
            </select>
        </label>
    </div>
    <div>
        <label>
            Names:
            <input name="names">
        </label>
    </div>
    <div>
        <label>
            Ages:
            <input name="ages">
        </label>
        <div>
            <input type="submit" name="filter" value="Filter!">
        </div>
    </div>
</form>
<?php
if (isset($errorMessage)) {
    echo "<p> $errorMessage </p>";
} else if (isset($students)) : ?>
    <br/>
    <table border="1" cellpadding="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($students as $studentName => $studentAge): ?>
            <tr>
                <td><?= $studentName; ?></td>
                <td><?= $studentAge; ?></td>
            </tr>
        <?php endforeach; ?>
        </tbody>
    </table>
<?php endif; ?>
</body>
</html>