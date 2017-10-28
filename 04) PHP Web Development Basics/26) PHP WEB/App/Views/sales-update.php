<div>
    <table class="table">
        <thead>
        <tr>
            <th>Amount</th>
            <th>Date</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($salesForUpdate as $currentSale): ?>
            <tr>
                <td><?= $currentSale['amount'] ?></td>
                <td><?= $currentSale['date_sold'] ?></td>
                <td><a href="/index.php?update=sales&id=<?= $currentSale['sale_id']?>">Update</a></td>
            </tr>
        <?php endforeach ?>
        </tbody>
    </table>
</div>
