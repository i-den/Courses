<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<?php if (!isset($_GET['submit'])): ?>
    <form method="get">
        <div>
            <textarea name="text"></textarea>
        </div>
        <div>
            <input type="submit" value="Count words" name="submit">
        </div>
    </form>
<?php elseif (isset($_GET['submit']) && !empty($_GET['text'])):
    $text = array_filter(array_map('strtolower', preg_split('/[^\w]+/', $_GET['text'])));
    $wordsValueArr = array();

    foreach ($text as $currWord) {
        if (!isset($wordsValueArr[$currWord])) {
            $wordsValueArr[$currWord] = 0;
        }

        $wordsValueArr[$currWord]++;
    }
    ?>
    <table border="2">
        <?php foreach ($wordsValueArr as $word => $value): ?>
            <tr>
                <td><?= $word ?></td>
                <td><?= $value ?></td>
            </tr>
        <?php endforeach; ?>
    </table>
<?php endif; ?>
</body>
</html>