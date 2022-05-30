<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEAD -->
<jsp:include page="../../includes/head.jsp">
	<jsp:param value="Product cart" name="title" />
</jsp:include>

<style>
.footer {
	margin-top: 280px;
	right: 0;
	left: 0;
	bottom: 0;
	width: 100%;
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
				<div class="col-8 offset-2">
					<h4 class="text-center" style="font-weight: 800;">Thông tin
						giỏ hàng của bạn</h4>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>STT</th>
								<th>Tên bánh</th>
								<th>Số lượng (Cái)</th>
								<th>Đơn giá</th>
								<th>Thành tiền</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<!-- Delete cart -->
							<c:set var="count" value="1" scope="page" />
							<c:forEach var="item" items="${Cart }">
								<tr>
									<td>${count }</td>
									<td>${item.value.product.tenSP }</td>
									<td>${item.value.soLuong }</td>
									<td>${item.value.product.donGia }đ</td>
									<td>${(item.value.soLuong)*(item.value.product.donGia) } đ</td>
									<td><a
										href='<c:url value="/delete-cart/${item.value.product.maSP }"></c:url>'>
											<button type="button" class="btn btn-danger"
												onclick="if(!(confirm('Bạn có muốn xóa sản phẩm này không này không?'))) return false;">X</button>
									</a></td>
								</tr>
								<c:set var="count" value="${count + 1}" scope="page" />
							</c:forEach>
						</tbody>
					</table>
					<!-- Check Cart Empty -->
					<c:if test="${empty Cart }">
						<p class="text-center">
							<i style="color: var(--primary-color);">Giỏ hàng rỗng.</i>
						</p>
					</c:if>
					<div class="d-flex justify-content-end">
						<a href='<c:url value="/product-payment"></c:url>'>
							<button type="button" class="btn btn-success mb-2">Đặt hàng</button>
						</a>
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