<?php /** @var \Data\EmailDTO $data */ ?>

<h1>Delete Email</h1>
<form method="post" action="delete-email.php?id=<?= $data->getId(); ?>">

    <p>
        Email Address: <?= $data->getEmail(); ?>
    </p>

    <br/>

    <input type="submit" name="delete" value="Delete!">

</form>

