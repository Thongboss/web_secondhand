<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in Second Hand Shop</title>
<link rel="stylesheet"
	href="/thongvhph13968_assignment_java4/CSS/bootstrap.min.css">
</head>
<body>
	<c:if test="${ !empty sessionScope.error }">
		<div class="alert alert-danger">${ sessionScope.error }</div>
		<c:remove var="error" scope="session" />
	</c:if>
	<div class="d-flex justify-content-center" style="padding-top: 200px">
		<form method="POST" action="/thongvhph13968_assignment_java4/home">
		    
			<div class="form-group">
			    <h1>Sign in</h1>
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" name="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email"> <small
					id="emailHelp" class="form-text text-muted">We'll never
					share your email with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" name="password" class="form-control" id="exampleInputPassword1"
					placeholder="Password">
			</div>
			<button type="submit" class="btn btn-primary" >Submit</button>
		</form>
	</div>
	<script src="/thongvhph13968_assignment_java4/JS/jquery.min.js"></script>
	<script src="/thongvhph13968_assignment_java4/JS/popper.min.js"></script>
	<script src="/thongvhph13968_assignment_java4/JS/bootstrap.min.js"></script>
</body>
</html>