<?php /** @var \Data\UserDTO[] $data */ ?>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Full Name</th>
        <th>Birthday</th>
    </tr>
    </thead>
    <tbody>
    <?php foreach($data as $user): ?>
        <tr>
            <td><?= $user->getId(); ?></td>
            <td><?= $user->getUsername(); ?></td>
            <td><?= $user->getFirstName() . ' ' . $user->getLastName(); ?></td>
            <td><?= $user->getBornOn(); ?></td>
        </tr>
    <?php endforeach; ?>
    </tbody>
</table>

<a href="profile.php">Profile</a>
