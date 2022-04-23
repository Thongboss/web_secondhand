<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>

<div class="d-flex justify-content-center" style="padding-top: 200px">
	<form method="POST"
		action="/thongvhph13968_assignment_java4/categories/store">
		<h2>Create category</h2>
		<div>
			<label>Category name</label> <input type="text" name="tenDanhmuc"
				placeholder="Category name" />
		</div>
		<div>
			<label>Creator</label> <select name="user_id">
				<c:forEach items="${ dsuser }" var="user">
					<option value="${ user.id }">${ user.hoTen }</option>
				</c:forEach>
			</select>
		</div>

		<button>Create</button>
	</form>
</div>
