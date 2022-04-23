<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:if test="${empty list }">
	<div class="alert alert-danger">empty list</div>
</c:if>
<c:if test="${!empty canhbao }">
      <div class="alert alert-waring">${canhbao }</div>
</c:if>
<form method="GET" action="/thongvhph13968_assignment_java4/home">
	<c:if test="${!empty phan }">
		<div class="alert alert-warning">
			<strong>${phan }</strong>
		</div>
	</c:if>
	<div class="container">
		<div class="d-flex flex-row flex-wrap">
			<c:forEach items="${list }" var="product">
				<div class="p-2">
					<div class="card">
						<img class="card-img-top" src="${product.img }"
							style="width: 300px; height: 300px">
						<div class="card-body">
							<h5 class="card-title" style="color: blue">${product.tensp }</h5>
							<span>${product.soLuong } pcs</span>
							<p>${product.donGia }VNĐ</p>
							<a
								href="/thongvhph13968_assignment_java4/detail?id=${ product.id }"
								class="btn btn-primary">detail</a>
							<button type="button" class="btn btn-success"
								data-bs-toggle="modal" data-bs-target="#exampleModalLong"
								onclick="">Add to cart</button>
							<div class="modal fade" id="exampleModalLong" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLongTitle"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLongTitle">Default purchase quantity</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
										<p>the number of products to be added automatically is 1</p>
										</div>
										
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-bs-dismiss="modal">Close</button>
											<a href="/thongvhph13968_assignment_java4/cart?id=${ product.id }" class="btn btn-success">Add</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</form>