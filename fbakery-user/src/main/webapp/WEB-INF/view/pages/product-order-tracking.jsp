<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEAD -->
<jsp:include page="../../includes/head.jsp">
	<jsp:param value="Product order tracking" name="title" />
</jsp:include>

<style>
	.footer {
	  margin-top: 170px;
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
			<div class="alert alert-success text-center">Đơn hàng của bạn
				đã được gửi đến cho chúng tôi, chúng tôi sẽ gửi sản phẩm cho bạn một
				cách nhanh nhất. Vui lòng kiểm tra tin nhắn điện thoại để nhận hóa đơn của bạn.</div>
				<h4 class="text-center" style="font-weight: 800;">Chi tiết hóa đơn của bạn</h4>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>STT</th>
							<th>Tên bánh</th>
							<th>Đơn giá</th>
							<th>Số lượng (Cái)</th>
							<th>Thành tiền</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="1" scope="page" />
						<c:forEach var="item" items="${list}">
							<tr>
								<td>${count }</td>
								<td>${item.sanPham.tenSP }</td>
								<td>${item.sanPham.donGia } đ</td>
								<td>
									<div class="form-group">
										<input type="text" class="form-control" disabled="disabled"
											value="${item.soLuong }" style="width: 50%;" />
									</div>
								</td>
								<!-- Get Thành Tiền -->
								<td>${(item.soLuong)*(item.sanPham.donGia)} đ</td>
								<c:set var="count" value="${count + 1}" scope="page" />
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td style="color: var(--primary-color); font-weight: 600" >Tổng tiền</td>
							<td style="color: var(--primary-color); font-weight: 600" >${totalMoney } đ.</td>
						</tr>
					</tbody>
				</table>
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

