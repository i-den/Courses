<div class="container">
    <form class="form-horizontal" method="post" action="/index.php?update=sales&id=<?= $id ?>">
        <div class="form-group">
            <label class="control-label col-sm-2" for="date">Date (Old: <?= $saleForUpdate['date_sold'] ?>)</label>
            <div class="col-sm-10">
                <input class="form-control" id="date" placeholder="New Date" name="dateSold">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="amount">Amount Paid (Old: <?= $saleForUpdate['amount'] ?>)</label>
            <div class="col-sm-10">
                <input class="form-control" id="amount" placeholder="New Amount" name="amount">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" name="submit-update">
            </div>
        </div>
    </form>
</div>

