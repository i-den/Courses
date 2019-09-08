<?php /** @var \Data\UserDTO[] $data */
/** @var \Data\PageDTO $pageInfo */ ?>

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
    <?php foreach ($data as $user): ?>
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

<?php foreach ($pageInfo->getPagesToPrint() as $page):
    if ($page === $pageInfo->getCurrentPage()): ?>
        <a href="all.php?page=<?= $page; ?>">[<?= $page; ?>]</a>
    <?php else: ?>
        <a href="all.php?page=<?= $page; ?>"><?= $page; ?></a>
    <?php endif;
endforeach; ?>
