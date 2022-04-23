<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ empty dspro }">
	<p class="alert alert-warning">no data</p>
</c:if>

<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success">${ sessionScope.message }</div>
	<c:remove var="message" scope="session" />
</c:if>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>

<c:if test="${ !empty dspro }">
	<table class="table">
		<thead class="table-dark">
			<th>Product name</th>
			<th>Quantity</th>
			<th>Unit price</th>
			<th>Color</th>
			<th>Size</th>
			<th>Image</th>
			<th colspan="2">Operation</th>
		</thead>
		<tbody>
			<c:forEach items="${ dspro }" var="pro">
				<tr>
					<td>${ pro.tensp }</td>
					<td>${pro.soLuong }pcs</td>
					<td>${ pro.donGia }VNĐ</td>
					<td>${ pro.mauSac }</td>
					<td>${ pro.kichThuoc }</td>
					<td><img src="${ pro.img }" alt="uploading" width="75px"
						height="75px" /></td>
					<td><a class="btn btn-primary"
						href="/thongvhph13968_assignment_java4/products/edit?id=${ pro.id }">
							Update </a></td>
					<td><a class="btn btn-danger"
						href="/thongvhph13968_assignment_java4/products/delete?id=${ pro.id }"
						onclick="return confirm('Do you want to delete the product ${pro.tensp}?');">
							Delete </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-outline-success"
		href="/thongvhph13968_assignment_java4/products/create">Create new</a>
</c:if>