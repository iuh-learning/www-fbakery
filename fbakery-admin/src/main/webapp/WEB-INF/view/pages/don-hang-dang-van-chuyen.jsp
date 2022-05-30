<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../includes/header.jsp">
	<jsp:param name="title" value="Admin - Order Shipping" />
</jsp:include>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Import side bar -->
		<jsp:include page="../../includes/side-bar.jsp" />

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Import nav bar -->
				<jsp:include page="../../includes/nav-bar.jsp" />

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Content Row -->
					<div class="row justify-content-center">
						<div class="track col-12">
							<div class="step active">
								<span class="icon"> <i class="fa fa-check"></i>
								</span> <span class="text">Chờ xác nhận</span>
							</div>
							<div class="step active">
								<span class="icon"> <i class="fa fa-user"></i>
								</span> <span class="text">Đang chuẩn bị</span>
							</div>
							<div class="step active">
								<span class="icon"> <i class="fa fa-truck"></i>
								</span> <span class="text">Đang vận chuyển</span>
							</div>
							<div class="step">
								<span class="icon"> <i class="fa fa-box"></i>
								</span> <span class="text">Đã nhận được hàng</span>
							</div>
						</div>
					</div>

					<div class="row">
						<!-- DataTales Example -->
						<div class="card shadow mb-4 col-12 m-0 ml-auto mr-auto">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Danh sách đơn
									hàng đang vận chuyển</h6>
							</div>

							<div class="card-body">
								<div
									class="table-responsive table-wrapper-scroll-y my-custom-scrollbar">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>STT</th>
												<th>Tên khách hàng</th>
												<th>Địa chỉ</th>
												<th>Số điện thoại</th>
												<th>Tổng tiền</th>
												<th>Ngày lập</th>
												<th>Trạng thái</th>
												<th></th>
											</tr>
										</thead>

										<tbody>
											<c:set var="count" value="1" scope="page" />
											<c:forEach var="item" items="${list }">
												<c:url var="loadUpdateLink"
													value="cap-nhat-thong-tin-hoa-don-dang-van-chuyen">
													<c:param name="orderID" value="${item.maHD}" />
												</c:url>
												<c:url var="loadOrderDetail" value="chi-tiet-hoa-don">
													<c:param name="orderID" value="${item.maHD}" />
												</c:url>
												<tr>
													<td>${count }</td>
													<td>${item.khachHang.tenKH }</td>
													<td>${item.khachHang.diaChi}</td>
													<td>${item.khachHang.sdt }</td>
													<td>${item.tongTien } đ</td>
													<td>${item.ngayLap }</td>
													<td class="text-info">Đang vận chuyển</td>
													<td class="p-0">
													<a href="${loadUpdateLink }" class="btn btn-link p-2"
														onclick="if(!(confirm('Bạn có chắc xác nhận đơn hàng này?'))) return false;">Xác
															nhận</a>
															<a href="${loadOrderDetail}" class="btn btn-link p-0">Xem chi tiết hóa đơn</a>
													</td>
												<c:set var="count" value="${count + 1}" scope="page"/>
											</c:forEach>
										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<jsp:include page="../../includes/footer.jsp" />
</body>

</html>