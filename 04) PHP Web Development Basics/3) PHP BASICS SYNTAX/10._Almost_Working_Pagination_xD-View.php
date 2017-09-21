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
if (!empty($_GET['error'])) {
    $dd = $_GET['error'];

    echo '<h3>' . $_GET['error'] . '</h3>';
} ?>

<?php if (!empty($studentsPaged)): ?>
    <table>
        <thead>
        <tr>
            <td>Names</td>
            <td>Ages</td>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($studentsPaged as $name => $age): ?>
            <tr>
                <td><?= $name; ?></td>
                <td><?= $age; ?></td>
            </tr>
        <?php endforeach; ?>
        </tbody>
    </table>
    <?php if ($hasPrevious): ?>
        <a href="10._Almost_Working_Pagination_xD.php?page=<?= $page - 1; ?>&<?= $queryString; ?>"> Previous </a>
        <?php if (!$hasNext): ?>
            <a href="10._Almost_Working_Pagination_xD.php?page=<?= $page; ?>&<?= $queryString; ?>">[<?= $page - 2; ?>]</a>
        <?php endif; ?>
        <a href="10._Almost_Working_Pagination_xD.php?page=<? $page - 1; ?>&<?= $queryString; ?>">[<?= $page - 1; ?>]</a>
    <?php endif; ?>
    <a style="color: red">[<?= $page; ?>]</a>
    <?php if ($hasNext): ?>
        <a href="10._Almost_Working_Pagination_xD.php?page=<?= $page + 1 ?>&<?= $queryString; ?>">[<?= $page + 1; ?>]</a>
        <?php if (!$hasPrevious): ?>
            <a href="10._Almost_Working_Pagination_xD.php?page=<?= $page + 2 ?>&<?= $queryString ?>">[<?= $page + 2; ?>]</a>
        <?php endif; ?>
        <a href="10._Almost_Working_Pagination_xD.php?page=<?= $page + 1 ?>&<?= $queryString; ?>"> Next </a>
    <?php endif; ?>
<?php endif; ?>
</body>
</html>