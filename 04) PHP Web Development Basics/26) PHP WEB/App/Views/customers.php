<div>
    <table class="table">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Family Name</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($allCustomers as $currentCustomer): ?>
            <tr>
                <td><?= $currentCustomer['first_name'] ?></td>
                <td><?= $currentCustomer['family_name'] ?></td>
            </tr>
        <?php endforeach ?>
        </tbody>
    </table>
</div>
