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
            <label>
                Categories:
                <input name="categories">
            </label>
        </div>
        <div>
            <label>
                Tags:
                <input name="tags">
            </label>
        </div>
        <div>
            <label>
                Months:
                <input name="months">
            </label>
        </div>
        <div>
            <input type="submit" name="submit">
        </div>
    </form>
<?php elseif (isset($_GET['submit'])
    && !empty($_GET['categories'])
    && !empty($_GET['tags'])
    && !empty($_GET['months'])
):
    $categories = explode(', ', htmlspecialchars($_GET['categories']));
    $tags = explode(', ', htmlspecialchars($_GET['tags']));
    $months = explode(', ', htmlspecialchars($_GET['months']));
    ?>

    <h2>Categories</h2>
    <ul>
        <?php foreach ($categories as $category): ?>
            <li><?= $category ?></li>
        <?php endforeach; ?>
    </ul>

    <h2>Tags</h2>
    <ul>
        <?php foreach ($tags as $tag): ?>
            <li><?= $tag ?></li>
        <?php endforeach; ?>
    </ul>

    <h2>Months</h2>
    <ul>
        <?php foreach ($months as $month): ?>
            <li><?= $month ?></li>
        <?php endforeach; ?>
    </ul>
<?php endif; ?>
</body>
</html>
