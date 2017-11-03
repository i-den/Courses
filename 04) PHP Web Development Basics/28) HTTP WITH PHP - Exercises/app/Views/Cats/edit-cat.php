 <div class="container">
    <form class="form-horizontal" method="post" action="/cats/edit/">
        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Name</label>
            <div class="col-sm-10">
                <input class="form-control" id="name" placeholder="<?= $cat->getName(); ?>" name="name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="age">Age</label>
            <div class="col-sm-10">
                <input class="form-control" id="age" placeholder="<?= $cat->getAge(); ?>" name="age">
            </div>
        </div>
        <input type="hidden" name="id" value="<?= $id; ?>">
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" name="submit-update">
            </div>
        </div>
    </form>
</div>