<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
	
</script>
<style type="text/css">
#mycontainer {
	background-color: orange;
}
</style>
</head>
<body>
	<div id="mycontainer" class="container">social icon</div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">My Bazar</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath}/">Home</a></li>
				<c:if test="${!sessionScope.loggedIn}">
					<li><a href="login">Login</a></li>
					<li><a href="register">Register</a></li>
					<li><a href="contactus">Contact Us</a></li>
					<li><a href="aboutus">About Us</a></li>
				</c:if>
				<c:if test="${sessionScope.loggedIn}">
					<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
						<li><a href="category">Category</a></li>
						<li><a href="product">Product</a></li>
						<li><a href="supplier">Supplier</a></li>
					</c:if>
					<c:if test="${sessionScope.role=='ROLE_USER'}">
						<li><a href="productDisplay">Display Product</a></li>
					</c:if>
				</c:if>
			</ul>
		</div>
		<div class="nav navbar-nav navbar-right">
			<c:if test="${sessionScope.loggedIn}">
				<font color="white" face="calibri" size="3">Welcome
					:${username}</font>
				<a href="perform_logout"><font color="white" face="calibri" size="2">LOGOUT</font></a>


			</c:if>

		</div>

	</nav>
      
      
      
<!--IMAGE SLIDER BEGINS-->
	<div class="carousel slide" id="carousel-1" data-ride="carousel">
<!--IMAGE SLIDER BEGINS-->
		<div class="carousel-inner" role="listenbox">
			<div class="item active">
				<img src="./resources/images/iphone-x.jpg" class="d-block img-fluid" title="Indian flag">
			</div>
			<div class="item">
				<img src="./resources/images/iphone-x.jpg" class="d block img-fluid" title="Indian Flag">
			</div>
			<div class="item">
				<img src="./resources/images/iphone-x.jpg" class="d block img-fluid" title="Gate Way Of India">
			</div>
			<div class="item">
				<img src="./resources/images/iphone-x.jpg" class="d block img-fluid" title="Golden Temple">
			</div>
			<div class="item">
				<img src="./resources/images/iphone-x.jpg" class="d block img-fluid" title="Akshardham Temple">
			</div>
			<div class="item">
				<img src="./resources/images/iphone-x.jpg" class="d block img-fluid" title="Yamuna Expressway">
			</div>
		</div>
<!--IMAGE SLIDER ENDS-->

<!--IMAGE SLIDER CONTROL BEGINS-->
		<a href="#carousel-1" class="left carousel-control" role="button" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			<span class="sr-only">PREVIOUS</span>
		</a>

		<a href="#carousel-1" class="right carousel-control" role="button" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">NEXT</span>
		</a>
<!--IMAGE SLIDER CONTROL ENDS-->
<!--CAROUSEL INDICATOR BEGINS-->
		<ol class="carousel-indicators">
			<li data-target="#carousel-1" data-slide-to="0" class="active"></li>
			<li data-target="#carousel-1" data-slide-to="1"></li>
			<li data-target="#carousel-1" data-slide-to="2" ></li>
			<li data-target="#carousel-1" data-slide-to="3" ></li>
			<li data-target="#carousel-1" data-slide-to="4"> </li>
			<li data-target="#carousel-1" data-slide-to="5"></li>




</ol>
</div>
