<table class="table">
    <thead>
    <tr>
        <th>Make</th>
        <th>Model</th>
        <th>Year</th>
        <th>Date Sold</th>
        <th>Amount</th>
    </tr>
    </thead>
    <tbody>
    <?php foreach ($allSales as $currentSale): ?>
        <tr class="row">
            <td><?= $currentSale['make'] ?></td>
            <td><?= $currentSale['model'] ?></td>
            <td><?= $currentSale['year'] ?></td>
            <td><?= $currentSale['date_sold'] ?></td>
            <td><?= $currentSale['amount'] ?></td>
        </tr>
    <?php endforeach ?>
    </tbody>
</table>