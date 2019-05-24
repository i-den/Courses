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
            <input type="submit" name="submit">
        </div>
    </form>
<?php elseif (isset($_GET['submit']) && !empty($_GET['text'])):
    $inputText = str_split(implode('', (preg_split('/[\s]+/', trim($_GET['text'])))));

    foreach ($inputText as $currChar):
        $charAsciiValue = ord($currChar);

        if ($charAsciiValue % 2 === 0): ?>
            <span style="color: red;"><?= $currChar; ?></span>
        <?php else: ?>
            <span style="color: blue;"><?= $currChar; ?></span>
        <?php endif;

    endforeach;

endif; ?>
</body>
</html>
