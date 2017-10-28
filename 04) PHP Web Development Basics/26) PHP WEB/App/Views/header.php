<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>James Dean's Car Shop</title>

    <script src="<?= 'http://' . HOST . '/Public/JavaScript/jquery-3.2.1.js' ?>"></script>
    <script src="<?= 'http://' . HOST . '/Public/JavaScript/bootstrap.js' ?>"></script>
    <link rel="stylesheet" type="text/css" href="<?= 'http://' . HOST . '/Public/Styles/bootstrap.css' ?>">
</head>

<body>

<header>
    <div class="navbar">
        <div class="navbar-default navbar-fixed-top text-uppercase">
            <div class="container">
                <div class="navbar-header">
                    <a href="/index.php" class="navbar-brand">James Dean's Car Shop</a>

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
                    </ul>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="container body-content">

