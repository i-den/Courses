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


<a href="all.php?page=1">[View All Users]</a>


<a href="new-email.php">[Add New Email Account]</a>


<a href="all-emails.php?page=1">[My Emails]</a>


<a href="logout.php">[Logout]</a>