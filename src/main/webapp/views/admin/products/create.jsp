<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>

<div class="d-flex justify-content-center" style="padding-top: 200px">
	<form method="POST"
		action="/thongvhph13968_assignment_java4/products/store">
		<h2>Create product</h2>
		<div>
			<label>Products name</label> <input type="text" name="tensp"
				placeholder="product name" Required />
		</div>
		<div>
			<label>Quantity</label> <input type="number" name="soLuong"
				placeholder="Quantity" Required />
		</div>
		<div>
			<label>Unit price</label> <input type="number" name="donGia"
				placeholder="Unit price" Required />
		</div>
		<div>
			<label>Size</label> <input type="text" name="kichThuoc"
				placeholder="size" Required />
		</div>
		<div>
			<label>Color</label> <input type="text" name="mauSac"
				placeholder="color" Required />
		</div>
		<div>
			<label>Image product</label> <input type="text" name="img"
				placeholder="photo link" Required />
		</div>
		<div>
			<label>Note</label><br>
			<textarea rows="7" cols="50" name="ghiChu" placeholder="note"
				Required></textarea>
		</div>
		<div>
			<label>Category</label> <select name="category_id">
				<c:forEach items="${ dscate }" var="cate">
					<option value="${ cate.id }">${ cate.tenDanhmuc }</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<button>Create</button>
			<button type="reset">Delete form</button>
		</div>
	</form>
</div>