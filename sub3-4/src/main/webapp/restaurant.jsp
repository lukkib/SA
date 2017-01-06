<html lang="en">
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="assets/img/favicon.png">

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Filter Stops</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/gsdk.css" rel="stylesheet" />
    <link href="assets/css/demo.css" rel="stylesheet" />

    <!--     Font Awesome     -->
    <link href="bootstrap3/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>

</head>


<style>
    .bg-1 {
        background-color: white;
        color: white;
        background-image: url('background.JPG');
        background-size: cover;
    }

    .fc {
        color: white;
    }
</style>

<body class="bg-1">

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Route Planner</a>
        </div>
        <a href="filterHome.jsp"><button class="btn fc navbar-btn">Stop Finder</button></a>
        <a href="connectionHome.jsp"><button class="btn fc navbar-btn">Connection Check</button></a>
        <a href="restaurant.jsp"><button class="btn fc navbar-btn" style="background-color: gray">Find Restaurant</button></a>
    </div>
</nav>

<div class="container">
    <h1>Find Restaurant</h1>
    <div class="container">
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="nearest stop"/>
                </div>
            </div>
            <div class="col-sm-2">
                <buttton type="button" class="btn btn-success btn-fill">Find Restaurant</buttton>
            </div>
        </div>
    </div>
</div>

</body>
</html>