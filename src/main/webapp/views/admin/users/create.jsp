<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>
<c:if test="${!empty sessionScope.message }">
	<div class="alert alert-danger">${ sessionScope.message }</div>
	<c:remove var="message" scope="session" />
</c:if>
<c:if test="${!empty warning }">
	<script>
    alert(${warning});
</script>
</c:if>

<div class="d-flex justify-content-center" style="padding-top: 200px">
	<form method="POST"
		action="/thongvhph13968_assignment_java4/users/store">
		<h2>Create new user</h2>
		<div>
			<label>Full name</label> <input type="text" name="hoTen"
				placeholder="Full name" Required />
		</div>
		<div>
			<label>Address</label> <input type="text" name="diaChi"
				placeholder="Address" Required />
		</div>
		<div>
			<label>Email</label> <input type="email" name="email"
				placeholder="Email" Required />
		</div>
		<div>
			<label>Password</label> <input type="password" name="password"
				placeholder="Password" Required />
		</div>
		<div>
			<label>Phone number</label> <input type="text" name="sdt"
				placeholder="Phone number" Required />
		</div>
		<div>
			<label>Genter</label> <input type="radio" name="gioiTinh" value="1"
				checked="checked" /> <label>Male</label> <input type="radio"
				name="gioiTinh" value="0" /> <label>Female</label>
		</div>
		<div>
			<label>Role</label> <input type="radio" name="role" value="admin"
				checked="checked" /> <label>Admin</label> <input type="radio"
				name="role" value="user" /> <label>user</label>
		</div>
		<div>
			<button>Create</button>
			<button type="reset">Delete form</button>
		</div>
	</form>
</div>