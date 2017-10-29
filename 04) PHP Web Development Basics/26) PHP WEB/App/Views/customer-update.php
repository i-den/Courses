<div class="container">
    <form class="form-horizontal" method="post" action="/index.php?update=customers&id=<?= $id ?>">
        <div class="form-group">
            <label class="control-label col-sm-2" for="first-name">Date</label>
            <div class="col-sm-10">
                <input class="form-control" id="first-name" placeholder="<?= $customerForUpdate['first_name'] ?>" name="firstName">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="family-name">Amount Paid</label>
            <div class="col-sm-10">
                <input class="form-control" id="family-name" placeholder="<?= $customerForUpdate['family_name'] ?>" name="familyName">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" name="submit-update">
            </div>
        </div>
    </form>
</div>

