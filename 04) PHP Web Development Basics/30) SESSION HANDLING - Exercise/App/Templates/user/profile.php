<?php /** @var \Data\UserDTO $data */ ?>

<h1>Update Profile</h1>
<form method="post" action="profile.php">


    Username:
    <input name="username" value="<?= $data->getUsername(); ?>">


    <br/>

    Password:
    <input name="password">


    <br/>

    First Name:
    <input name="firstName" value="<?= $data->getFirstName(); ?>">


    <br/>

    Last Name:
    <input name="lastName" value="<?= $data->getLastName(); ?>">


    <br/>

    Birthday:
    <input name="bornOn" value="<?= $data->getBornOn(); ?>">


    <br/>

    <input type="submit" name="update">

</form>


<a href="all.php">view users</a>

<a href="logout.php">logout</a>