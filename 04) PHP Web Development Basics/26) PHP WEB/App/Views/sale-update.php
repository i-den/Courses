<div class="container">
    <form class="form-horizontal" method="post" action="/index.php?update=sales&id=<?= $id ?>">
        <div class="form-group">
            <label class="control-label col-sm-2" for="date">Date</label>
            <div class="col-sm-10">
                <input class="form-control" id="date" placeholder="<?= $saleForUpdate['date_sold'] ?>" name="dateSold">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="amount">Amount Paid</label>
            <div class="col-sm-10">
                <input class="form-control" id="amount" placeholder="<?= $saleForUpdate['amount'] ?>" name="amount">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" name="submit-update">
            </div>
        </div>
    </form>
</div>

