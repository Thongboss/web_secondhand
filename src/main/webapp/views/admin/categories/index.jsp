<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ empty dscate }">
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

<c:if test="${!empty dscate }">
	<table class="table">
		<thead class="table-dark">
			<th>Category name</th>
			<th>Creator name</th>
			<th colspan="2">Operation</th>
		</thead>
		<tbody>
		    <c:forEach items="${dscate }" var="cate">
		          <tr>
		             <td>${cate.tenDanhmuc }</td>
		             <td>${cate.user.hoTen }</td>
		             <td><a class="btn btn-primary"
						href="/thongvhph13968_assignment_java4/categories/edit?id=${ cate.id }">
							Update </a></td>
					<td><a class="btn btn-danger"
						href="/thongvhph13968_assignment_java4/categories/delete?id=${ cate.id }"  onclick="return confirm('Are you sure you want to delete the category ${cate.tenDanhmuc}?');">
							Delete </a></td>
		          </tr>
		    </c:forEach>
		</tbody>
	</table>
	<a class="btn btn-outline-success" href="/thongvhph13968_assignment_java4/categories/create">Create new</a>
</c:if>