<?php
/**
 * @var \Data\UserDTO
 */
$data

?>
<h1>Your Profile</h1>
<form method="post">
    <div>
        <label>
            Username:
            <input value="<?= $data->getUsername(); ?>" name="username">
        </label>
    </div>
    <div>
        <label>
            Password:
            <input type="password" name="password">
        </label>
    </div>
    <div>
        <label>
            First Name:
            <input value="<?= $data->getFirstName(); ?>" name="first_name">
        </label>
    </div>
    <div>
        <label>
            Last Name:
            <input value="<?= $data->getLastName(); ?>" name="last_name">
        </label>
    </div>
    <div>
        <label>
            Birthday:
            <input value="<?= $data->getBornOn(); ?>" name="born_on">
        </label>
    </div>
    <div>
        <input type="submit" name="edit" value="Edit!">
    </div>
</form>

<p>You can <a href="logout.php">Logout</a> or see <a href="all.php">All Users</a></p>