<?php

use Data\UserDTO;
use Database\PDODatabase;

require_once '../vendor/autoload.php';

$pdo = new PDO('mysql:host=127.0.0.1;dbname=session_handling;charset=utf8', 'root', 'pass123');

$db = new PDODatabase($pdo);

$stmt = $db->query(
        "SELECT `id`, `username`, `password`, `first_name` AS `firstName`, `last_name` AS `lastName`, `born_on` AS `borOn` FROM `users`"
);

$rs = $stmt->execute();

$allUsers = $rs->fetchAll(UserDTO::class);

/** @var UserDTO $user */
foreach ($allUsers as $user) {
    var_dump($user);
}

?>
<!DOCTYPE HTML>
<html lang="en-US">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Index</title>

</head>

<body>

<h1>Hello, Guest</h1>
<p>If you have an account, you can <a href="login.php">login</a> to our system.</p>
<p>Otherwise, just <a href="register.php">register here.</a></p>

</body>

</html>