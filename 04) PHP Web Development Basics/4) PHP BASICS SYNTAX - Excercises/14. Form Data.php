<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form method="get" action="index.php">
    <div>
        <input name="name" placeholder="Name...">
    </div>
    <div>
        <input name="age" placeholder="Age...">
    </div>
    <div>
        <input type="radio" name="gender" value="Male"> Male
    </div>
    <div>
        <input type="radio" name="gender" value="Female"> Female
    </div>
    <div>
        <input type="submit">
    </div>
</form>
<?php
if (isset($_GET['name'], $_GET['age'], $_GET['gender'])
    && !empty($_GET['name'])
    && !empty($_GET['age'])
    && !empty($_GET['gender'])
) {
    $name = $_GET['name'];
    $age = $_GET['age'];
    $gender = $_GET['gender'];

    echo "<p>My name is $name. I am $age years old. I am $gender.</p>";
}
?>
</body>
</html>
