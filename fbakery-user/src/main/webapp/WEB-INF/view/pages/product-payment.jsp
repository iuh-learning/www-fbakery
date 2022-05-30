<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- HEAD -->
<jsp:include page="../../includes/head.jsp">
	<jsp:param value="Product Payment" name="title" />
</jsp:include>

<style>
.error {
	font-size: 15px;
	color: red
}
</style>

<body>

	<!-- Home page -->
	<div class="container-fluid mt-3">
		<div class="">
			<!-- HEARDER-->
			<jsp:include page="../../includes/header.jsp"></jsp:include>

			<!-- Scroll menu -->
			<jsp:include page="../../includes/scroll-menu.jsp"></jsp:include>

			<div class="row">
				<!-- Content -->
			<div class="col-10 offset-1">
				<h4 class="text-center" style="font-weight: 800;">Danh sách chi tiết sản phẩm</h4>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>STT</th>
							<th>Tên bánh</th>
							<th>Đơn giá</th>
							<th>Số lượng (Cái)</th>
							<th></th>
							<th>Thành tiền</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="1" scope="page" />
						<c:forEach var="item" items="${Cart }">
							<tr>
								<td>${count }</td>
								<td>${item.value.product.tenSP }</td>
								<td>${item.value.product.donGia } đ</td>
								<td style="width: 10%">
									<div class="form-group">
										<input type="number" class="form-control inp-check-number" id="quanty-cart-${item.value.product.maSP }"
											value="${item.value.soLuong }" style="width: 100%;" />
									</div>
								</td>
								<td>
									<div class="form-group">
										<!-- Edit Quanty Cart -->
										<button data-id="${item.value.product.maSP }" class="btn btn-success btn-edit-cart" style="width: 40%;">Lưu</button>
									</div>
								</td>
								<!-- Get Thành Tiền -->
								<td>${(item.value.soLuong)*(item.value.product.donGia) } đ</td>
								<td><a
									href='<c:url value="/delete-product-pay/${item.value.product.maSP }"></c:url>'>
										<button type="button" class="btn btn-danger" onclick="if(!(confirm('Bạn có muốn xóa sản phẩm này không này không?'))) return false;">X</button>
								</a></td>
							</tr>
							<c:set var="count" value="${count + 1}" scope="page" />
						</c:forEach>

					</tbody>
				</table>
				<!-- Check Cart Empty -->
				<c:if test="${empty Cart }">
					<p class="text-center">
						<i style="color: var(--primary-color);">Không có sản phẩm nào để đặt hàng.</i>
					</p>
				</c:if>

				<!-- Card Thông Tin Khách Hàng + Button Đặt Hàng -->
				<div class="col-6 offset-3 mb-4">
					<div class="card inf_customer-payment" style="margin-left: 60px;">
						<div class="card-header">
							<h4 class="text-center" style="font-weight: 800;">Thông tin
								của khách hàng đặt hàng</h4>
						</div>
						<div class="card-body">
							<c:if test="${not empty param.size}">
								<div class="alert alert-danger text-center">Bạn chưa chọn
									sản phẩm nào không thể đặt hàng!</div>
							</c:if>

							<form:form action="customer-payment" method="POST"
								modelAttribute="customer">
								<form:hidden path="maKH" />
								<div class="form-group">
									<label>Họ và tên khách hàng: </label>
									<form:input path="tenKH" class="form-control" />
									<label><form:errors path="tenKH" class="error" /></label>
								</div>
								<div class="form-group">
									<label>Số điện thoại khách hàng: </label>
									<form:input path="sdt" class="form-control" />
									<label><form:errors path="sdt" class="error" /></label>
								</div>
								<div class="form-group">
									<label>Địa chỉ khách hàng: </label>
									<form:input path="diaChi" class="form-control" />
									<label><form:errors path="diaChi" class="error" /></label>
								</div>

								<!-- Confirm -->
								<input type="Submit" value="Xác nhận đặt hàng" onclick="if(!(confirm('Bạn có chắc xác nhận đặt đơn hàng này không? (Đơn hàng chỉ được giao trong nội địa TP. HCM).'))) return false;"
									class="btn btn-success" style="width: 100%">
							</form:form>
						</div>
					</div>
				</div>
			</div>
			</div>

			<!-- Footer -->
			<jsp:include page="../../includes/footer.jsp"></jsp:include>

			<!-- show arrow up -->
			<span class="show_arrow-up"> <a href="#"><i
					class="fa-solid fa-arrow-up"></i></a>
			</span>
		</div>
	</div>
</body>

</html>