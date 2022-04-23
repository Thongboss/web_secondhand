<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>

<div class="d-flex justify-content-center" style="padding-top: 200px">
    <form method="POST"
	action="/thongvhph13968_assignment_java4/categories/update?id=${ category.id }">
	<div>
	     <h2>Edit category ${category.tenDanhmuc }</h2>
		<label>Category name</label> <input type="text" name="tendm" value="${category.tenDanhmuc }"/>
		<label>Creator</label><input type="text" name="creator" value="${category.user.hoTen}" disable/>
	</div>
	<div>
		<button>Update</button>
		<button type="reset">Delete form</button>
	</div>
</form>
</div>