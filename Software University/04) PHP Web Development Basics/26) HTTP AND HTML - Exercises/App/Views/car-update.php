<div class="container">
    <form class="form-horizontal" method="post" action="/index.php?update=cars&id=<?= $id ?>">
        <div class="form-group">
            <label class="control-label col-sm-2" for="make">Make</label>
            <div class="col-sm-10">
                <input class="form-control" id="make" placeholder="<?= $carForUpdate['make'] ?>" name="make">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="model">Model</label>
            <div class="col-sm-10">
                <input class="form-control" id="model" placeholder="<?= $carForUpdate['model'] ?>" name="model">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="year">Year</label>
            <div class="col-sm-10">
                <input class="form-control" id="year" placeholder="<?= $carForUpdate['year'] ?>" name="year">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" name="submit-update">
            </div>
        </div>
    </form>
</div>

