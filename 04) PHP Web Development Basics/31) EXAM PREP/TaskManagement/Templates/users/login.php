<?php /** @var \TaskManagement\DTO\UserDTO | null $data */
foreach ($errors as $error): ?>
    <p><?= $error; ?></p>
<?php endforeach; ?>
<form method="post">
    Username: <input  type="text" name="username" value="<?= $data != null ? $data->getUsername() : ''; ?>"><br/>
    Password: <input  type="password" name="password" value="<?= $data != null ? $data->getUsername() : ''; ?>"><br/>
    <input type="submit" name="login" value="Login!">
</form>
