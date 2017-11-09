<?php /** @var \Data\EmailDTO[] $data */ ?>
<?php /** @var \Data\PageDTO $pageInfo */ ?>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <?php foreach ($data as $email): ?>
        <tr>
            <td><?= $email->getId(); ?></td>
            <td><?= $email->getEmail(); ?></td>
            <td><a href="update-email.php?id=<?= $email->getId(); ?>">[Update]</a></td>
            <td><a href="delete-email.php?id=<?= $email->getId(); ?>">[Delete]</a></td>
        </tr>
    <?php endforeach; ?>
    </tbody>
</table>

<a href="profile.php">Profile</a>

<?php foreach ($pageInfo->getPagesToPrint() as $page):
    if ($page === $pageInfo->getCurrentPage()): ?>
        <a href="all-emails.php?page=<?= $page; ?>">[<?= $page; ?>]</a>
    <?php else: ?>
        <a href="all-emails.php?page=<?= $page; ?>"><?= $page; ?></a>
    <?php endif;
endforeach; ?>
