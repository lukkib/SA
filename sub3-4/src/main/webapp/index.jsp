<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" href="assets/img/favicon.png">
		
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>Route Planner</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    
    <link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
	<link href="assets/css/gsdk.css" rel="stylesheet" />
    <link href="assets/css/demo.css" rel="stylesheet" />

    <!--     Font Awesome     -->
    <link href="bootstrap3/css/font-awesome.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Grand+Hotel' rel='stylesheet' type='text/css'>
  
</head>

<%@ page contentType="text/html; charset=UTF-8" %>
<style>
    .bg-1 {
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
        <a class="container-fluid"></a>
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Route Planner</a>
            </div>
            <a href="index.jsp"><button class="btn fc navbar-btn" style="background-color: gray">Stop Finder</button></a>
            <a href="connection.html"><button class="btn fc navbar-btn">Connection Check</button></a>
            <a href="restaurant.html"><button class="btn fc navbar-btn">Find Restaurant</button></a>
    </nav>

            <div class="container">
                <h1>Filter Stops</h1>

                <div class="container">


                    <form action="FilterServlet" method="post">



                <div class="row">
                    <div class="col-sm-3">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Name" id="nameForm" name="name">
                            </div>

                    </div>
                    <div class="col-sm-9">
                        <div class="col-sm-5">
                            <div class="btn-group pull-right" role="group">
                                <button type="button" class="btn btn-danger btn-fill">Lower</button>
                                <button type="button" class="btn btn-success btn-fill">Greater</button>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="form-horizontal">
                                <div class="form-group text-left pull-left">
                                    <input type="text" class="form-control" placeholder="Longitude" id="lonForm" name="longitude">
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            <div class="row">
                <div class="col-sm-3">

                    <button type="submit" class="btn btn-primary btn-fill">Find Stops!</button>


                </div>
                <div class="col-sm-9">
                    <div class="col-sm-5">
                        <div class="btn-group pull-right" role="group">
                            <button type="button" class="btn btn-danger btn-fill">Lower</button>
                            <button type="button" class="btn btn-success btn-fill">Greater</button>
                        </div>
                    </div>
                    <div class="col-sm-7">
                        <div class="form-horizontal">
                            <div class="form-group text-left pull-left">
                                <input type="text" class="form-control"  placeholder="Latitude" id="latForm" name="latitude">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                    </form>
        </div>
    </div>
<!--
    <div class="container">
        <nav>
            <ul>
                <li><button class="btn fc navbar-btn" style="background-color: gray"></li>
                <li>Link 2</li>
                <li>Link 3</li>
                <li>Link 4</li>
                <li>Link 5</li>
                <li>Link 6</li>
                <li>Link 7</li>
                <li>Link 8</li>
                <li>Link 9</li>
                <li>Link 10</li>
                <li>Link 11</li>
                <li>Link 13</li>
                <li>Link 13</li>

            </ul>
        </nav>
    </div>
 -->

</body>

    <!--<script src="jquery/jquery-1.10.2.js" type="text/javascript"></script>-->
	<!--<script src="assets/js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>-->

	<script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
	<script src="assets/js/gsdk-checkbox.js"></script>
	<script src="assets/js/gsdk-radio.js"></script>
	<script src="assets/js/gsdk-bootstrapswitch.js"></script>
	<script src="assets/js/get-shit-done.js"></script>

    <script src="assets/js/custom.js"></script>
</html>