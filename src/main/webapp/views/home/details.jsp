<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="d-flex justify-content-center" style="padding-top: 200px">
	<form method="POST" action="/thongvhph13968_assignment_java4/detail">
	    <h2>product details ${product.tensp }</h2>
		<div class="p-2">
			<div class="card">
				<img class="card-img-top" src="${product.img }"
					style="width: 300px; height: 300px">
				<div class="card-body">
					<h5 class="card-title" style="color: blue">${product.tensp }</h5>
					<span>Quantity: ${product.soLuong } pcs</span>
					<p>Unit price: ${product.donGia }VNĐ</p>
					<p>Color: ${product.mauSac }</p>
					<p>Size: ${product.kichThuoc }</p>
					<p>Note: ${product.ghiChu }</p>
					<a href="#" class="btn btn-success">Add to cart</a>
				</div>
			</div>
		</div>
	</form>
</div>