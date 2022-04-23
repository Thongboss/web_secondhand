<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ !empty listpro }">
	<table class="table">
		<thead class="table-dark">
			<th>Product name</th>
			<th>Quantity purchased</th>
			<th>Unit price</th>
			<th>Color</th>
			<th>Size</th>
			<th>Image</th>
			<th colspan="2">Operation</th>
		</thead>
		<tbody>
			<c:forEach items="${ listpro }" var="pro">
				<tr>
					<td>${ pro.tensp }</td>
					<td>${pro.soLuong }pcs</td>
					<td>${ pro.donGia }VNĐ</td>
					<td>${ pro.mauSac }</td>
					<td>${ pro.kichThuoc }</td>
					<td><img src="${ pro.img }" alt="uploading" width="75px"
						height="75px" /></td>
					<td><a class="btn btn-primary"
						href="#">
							quantity change </a></td>
					<td><a class="btn btn-danger"
						href="#"
						onclick="return confirm('Do you want to remove from cart the product ${pro.tensp}?');">
							remove from cart </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-outline-success"
		href="#">Order</a>
</c:if>