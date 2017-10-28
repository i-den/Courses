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
        <?php foreach ($allCars as $currentCar): ?>
            <tr>
                <td><?= $currentCar['make'] ?></td>
                <td><?= $currentCar['model'] ?></td>
                <td><?= $currentCar['year'] ?></td>
            </tr>
        <?php endforeach ?>
        </tbody>
    </table>
</div>
