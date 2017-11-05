<div class="container">
    <form class="form-horizontal" method="post" action="/cats/new">

        <div class="form-group">
            <label class="control-label col-sm-2" for="name">Cat Name</label>
            <div class="col-sm-10">
                <input class="form-control" id="name" placeholder="Name" name="name">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="age">Cat Age</label>
            <div class="col-sm-10">
                <input class="form-control" id="age" placeholder="Age" name="age">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" class="btn btn-default" name="submit">
            </div>
        </div>
    </form>
</div>
