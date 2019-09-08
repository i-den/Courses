<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ivan Denchev's Dil... Car Shop</title>

    <script src="<?= 'http://' . HOST . '/Public/JavaScript/jquery-3.2.1.js' ?>"></script>
    <script src="<?= 'http://' . HOST . '/Public/JavaScript/bootstrap.js' ?>"></script>
    <link rel="stylesheet" type="text/css" href="<?= 'http://' . HOST . '/Public/Styles/bootstrap.css' ?>">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

<header>
    <div class="navbar">
        <div class="navbar-default navbar-fixed-top text-uppercase">
            <div class="container">
                <div class="navbar-header">
                    <a href="/index.php" class="navbar-brand">Dildo Shop</a>

                </div>
                <div class="navbar-collapse">
                    <ul class="nav navbar-nav ">
                        <li><a href="./index.php?list=sales">All Full Sales</a> </li>
                        <li><a href="./index.php?list=cars">All Cars Sold</a> </li>
                        <li><a href="./index.php?list=customers">All Customers</a> </li>
                        <li class="dropdown">
                            <a href="#" data-toggle="dropdown" class="dropdown-toggle">Update<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="./index.php?update=sales">Sale</a></li>
                                <li><a href="./index.php?update=cars">Car</a></li>
                                <li><a href="./index.php?update=customers">Customer</a></li>
                            </ul>
                        </li>
                        <div class="col-sm-3 col-md-3">
                            <form class="navbar-form" role="search">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="<?php if (isset($_GET['search'])) {echo $_GET['search']; } else {echo 'Search'; } ?>" name="search">
                                    <div class="input-group-btn">
                                        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-star" aria-hidden="true"></span></button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="container body-content">

