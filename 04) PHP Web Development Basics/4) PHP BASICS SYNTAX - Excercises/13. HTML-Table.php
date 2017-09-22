<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<?php if (!isset($_POST['name'], $_POST['phone'], $_POST['age'], $_POST['address'])): ?>
    <form method="post">
        <div>
            <label>
                Name:
                <input name="name">
            </label>
        </div>
        <div>
            <label>
                Phone Number:
                <input name="phone">
            </label>
        </div>
        <div>
            <label>
                Age:
                <input name="age">
            </label>
        </div>
        <div>
            <label>
                Address:
                <input name="address">
            </label>
        </div>
        <input type="submit" value="Submit!">
    </form>
<?php elseif (!empty($_POST['name']) && !empty($_POST['phone']) && !empty($_POST['age']) && !empty($_POST['address'])): ?>
    <table border="1px solid black">
        <tr>
            <td>Name</td>
            <td><?= $_POST['name']; ?></td>
        </tr>
        <tr>
            <td>Phone Number</td>
            <td><?= $_POST['phone'] ?></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><?= $_POST['age'] ?></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><?= $_POST['address'] ?></td>
        </tr>
    </table>
<?php endif; ?>
</body>
</html>
