<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SECOND HAND SHOP</title>
<link rel="stylesheet"
	href="/thongvhph13968_assignment_java4/CSS/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#" style="color: blue">Second Hand
				Shop</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/thongvhph13968_assignment_java4/home">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/thongvhph13968_assignment_java4/products/index">Product</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Category </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="/thongvhph13968_assignment_java4/products/coat">coat</a></li>
							<li><a class="dropdown-item" href="/thongvhph13968_assignment_java4/products/shirt">Shirt</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="/thongvhph13968_assignment_java4/products/sport">Sport shorts</a></li>
							<li><a class="dropdown-item" href="/thongvhph13968_assignment_java4/products/shorts">Shorts</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item"
								href="/thongvhph13968_assignment_java4/categories/index">All</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link"
						href="/thongvhph13968_assignment_java4/users/index">Admin</a></li>
				</ul>
				<form class="d-flex">
					<a class="btn btn-outline-info" style="margin-right: 30px">Cart</a>
					<a class="btn btn-outline-dark" href="/thongvhph13968_assignment_java4/login">Log out</a>
				</form>
			</div>
		</div>
	</nav>
	<div class="row">
		<!-- <div class="col-2">Sidebar</div> -->
		<div class="bg-warning" style="height: 1000px; padding-top: 20px">
			<jsp:include page="${view }"></jsp:include>
		</div>
	</div>
	<footer style="background-color: #2a2730" style="height: 200px">
		<div class="container">
			<p style="color: white">Võ Hữu Thông - PH13968 - SecondHand Shop</p>
			<p style="color: white">secondhandshop@gmail.com</p>
		</div>
	</footer>
	<script src="/thongvhph13968_assignment_java4/JS/jquery.min.js"></script>
	<script src="/thongvhph13968_assignment_java4/JS/popper.min.js"></script>
	<script src="/thongvhph13968_assignment_java4/JS/bootstrap.min.js"></script>
</body>
</html>