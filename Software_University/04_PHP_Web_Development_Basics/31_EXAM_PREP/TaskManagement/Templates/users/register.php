<?php /** @var \TaskManagement\DTO\UserDTO $data */ ?>
<?php foreach ($errors as $error): ?>
    <p><?= $error; ?></p>
<?php endforeach; ?>
<form method="post">
    Username: <input  type="text" name="username" value="<?= $data != null ? $data->getUsername() : ''; ?>"><br/>
    Password: <input  type="password" name="password" value="<?= $data != null ? $data->getPassword() : ''; ?>"><br/>
    Confirm Password: <input  type="text" name="confirm_password"><br/>
    First Name: <input  type="text" name="first_name" value="<?= $data != null ? $data->getFirstName() : ''; ?>"><br/>
    Last Name: <input  type="text" name="last_name" value="<?= $data != null ? $data->getLastName() : ''; ?>"><br/>
    <input type="submit" name="register" value="Register!"/>
</form>
