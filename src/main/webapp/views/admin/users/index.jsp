<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ empty ds }">
	<p class="alert alert-warning">no data</p>
</c:if>

<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success">
		${ sessionScope.message }
	</div>
	<c:remove var="message" scope="session" />
</c:if>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">
		${ sessionScope.error }
	</div>
	<c:remove var="error" scope="session" />
</c:if>

<c:if test="${ !empty ds }">
	<table class="table">
		<thead class="table-dark">
			<th>Full name</th>
			<th>Genter</th>
			<th>Address</th>
			<th>Phone number</th>
			<th>Email</th>
			<th>Role</th>
			<th colspan="2">Operation</th>
		</thead>
		<tbody>
			<c:forEach items="${ ds }" var="user">
				<tr>
					<td>${ user.hoTen }</td>
					<td><c:choose>
							<c:when test="${ user.gioiTinh == 1 }">Nam</c:when>
							<c:when test="${ user.gioiTinh == 0 }">Nữ</c:when>
							<c:otherwise> - </c:otherwise>
						</c:choose></td>
					<td>${ user.diaChi }</td>
					<td>${ user.sdt }</td>
					<td>${ user.email }</td>
					<td>${ user.role }</td>
					<td><a class="btn btn-primary"
						href="/thongvhph13968_assignment_java4/users/edit?id=${ user.id }">
							Update </a></td>
					<td><a class="btn btn-danger"
						href="/thongvhph13968_assignment_java4/users/delete?id=${ user.id }"  onclick="return confirm('Do you want to delete users ${user.hoTen}?');">
							Delete </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-outline-success" href="/thongvhph13968_assignment_java4/users/create">Create new</a>
</c:if>