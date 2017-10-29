<div>
    <table class="table">
        <thead>
        <tr>
            <th>Make</th>
            <th>Model</th>
            <th>Year</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($carsForUpdate as $Car): ?>
            <tr>
                <td><?= $Car['make'] ?></td>
                <td><?= $Car['model'] ?></td>
                <td><?= $Car['year'] ?></td>
                <td><a href="/index.php?update=cars&id=<?= $Car['car_id']?>">Update</a></td>
            </tr>
        <?php endforeach ?>
        </tbody>
    </table>
</div>
