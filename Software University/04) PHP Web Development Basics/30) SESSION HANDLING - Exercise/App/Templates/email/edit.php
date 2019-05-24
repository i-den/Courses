<?php /** @var \Data\EmailDTO $data */ ?>

<h1>Update Email</h1>
<form method="post" action="update-email.php?id=<?= $data->getId(); ?>">

    Email Address:
    <input name="email" value="<?= $data->getEmail(); ?>">

    <br/>

    <input type="submit" name="update">

</form>

