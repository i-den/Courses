<div>
    <table class="table">
        <thead>
        <tr>
            <th>Make</th>
            <th>Model</th>
            <th>Year</th>
            <th>Car ID</th>
            <th>First Name</th>
            <th>Family Name</th>
            <th>Customer ID</th>
        </tr>
        </thead>
        <tbody>
        <?php foreach ($allCars as $currentCar): ?>
            <tr>
                <td><?= $currentCar['make'] ?></td>
                <td><?= $currentCar['model'] ?></td>
                <td><?= $currentCar['year'] ?></td>
                <td><?= $currentCar['car_id'] ?></td>
                <td><?= $currentCar['first_name'] ?></td>
                <td><?= $currentCar['family_name'] ?></td>
                <td><?= $currentCar['customer_id'] ?></td>
            </tr>
        <?php endforeach ?>
        </tbody>
    </table>
</div>
