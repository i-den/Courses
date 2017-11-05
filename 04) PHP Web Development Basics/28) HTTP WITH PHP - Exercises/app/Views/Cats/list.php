<div>
    <table class="table">
        <thead>
        <tr>
            <th>Cat Name</th>
            <th>Cat Age</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($allCats as $cat): ?>
            <tr>
                <td><?= $cat['name'] ?></td>
                <td><?= $cat['age'] ?></td>
                <td><a href="/cats/edit?id=<?= $cat['cat_id']; ?>">Edit</a></td>
                <td><a href="/cats/delete?id=<?= $cat['cat_id']; ?>">Delete</a></td>
            </tr>
        <?php endforeach ?>
        </tbody>
    </table>
</div>