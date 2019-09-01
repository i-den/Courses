<div>
    <table class="table">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Family Name</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($customersForUpdate as $currentCustomer): ?>
            <tr>
                <td><?= $currentCustomer['first_name'] ?></td>
                <td><?= $currentCustomer['family_name'] ?></td>
                <td><a href="/index.php?update=customers&id=<?= $currentCustomer['customer_id']?>">Update</a></td>
            </tr>
        <?php endforeach ?>
        </tbody>
    </table>
</div>
