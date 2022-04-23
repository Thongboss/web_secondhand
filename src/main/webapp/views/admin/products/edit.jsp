<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<div class="d-flex justify-content-center" style="padding-top: 200px">
	<form method="POST"
		action="/thongvhph13968_assignment_java4/products/update?id=${product.id }">
		<h2>Edit product ${product.tensp }</h2>
		<div>
			<label>Products name</label> <input type="text" name="tensp"
				value="${product.tensp }" Required />
		</div>
		<div>
			<label>Quantity</label> <input type="number" name="soLuong"
				value="${product.soLuong }" Required />
		</div>
		<div>
			<label>Unit price</label> <input type="number" name="donGia"
				value="${product.donGia }" Required />
		</div>
		<div>
			<label>Size</label> <input type="text" name="kichThuoc"
				value="${product.kichThuoc }" Required />
		</div>
		<div>
			<label>Color</label> <input type="text" name="mauSac"
				value="${product.mauSac }" Required />
		</div>
		<div>
			<label>Image product</label> <input type="text" name="img"
				value="${product.img }" Required />
		</div>
		<div>
			<label>Note</label><br>
			<textarea rows="7" cols="50" name="ghiChu" Required>${product.ghiChu }</textarea>
		</div>
		<div>
			<button>Update</button>
			<button type="reset">Delete form</button>
		</div>
	</form>
</div>