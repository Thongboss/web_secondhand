<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="d-flex justify-content-center" style="padding-top: 200px">
	<form method="POST"
		action="/thongvhph13968_assignment_java4/users/update?id=${ user.id }">
		<h2>edit user ${user.hoTen }</h2>
		<div>
			<label>Full name</label> <input type="text" name="hoTen"
				value="${ user.hoTen }" Required />
		</div>
		<div>
			<label>Address</label> <input type="text" name="diaChi"
				value="${ user.diaChi }" Required />
		</div>
		<div>
			<label>Email</label> <input type="email" name="email"
				value="${ user.email }" Required />
		</div>
		<div>
			<label>Phone number</label> <input type="text" name="sdt"
				value="${ user.sdt }" Required />
		</div>
		<div>
			<label>Genter</label> <input type="radio" name="gioiTinh" value="1"
				${ user.gioiTinh == 1 ? "checked" : "" } /> <label>Male</label>
			<input type="radio" name="gioiTinh" value="0"
				${ user.gioiTinh == 0 ? "checked" : "" } /> <label>Female</label>
		</div>
		<div>
			<label>Role</label> <input type="radio" name="role" value="admin"
				${ user.role == "admin" ? "checked" : "" } /> <label>Male</label>
			<input type="radio" name="gioiTinh" value="0"
				${ user.role == "user" ? "checked" : "" } /> <label>user</label>
		</div>
		<div>
			<button>Update</button>
			<button type="reset">Delete form</button>
		</div>
	</form>
</div>