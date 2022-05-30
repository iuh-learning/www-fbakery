<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../includes/header.jsp">
	<jsp:param name="title" value="Admin - Dashboard" />
</jsp:include>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Import side bar -->
		<jsp:include page="../includes/side-bar.jsp" />

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Import nav bar -->
				<jsp:include page="../includes/nav-bar.jsp" />

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
					</div>

					<!-- Content Row -->
					<div class="row">

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												Khách hàng mới</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${customerSize}</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-users fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-success shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-success text-uppercase mb-1">
												Đơn hàng đang chờ xác nhận</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${loadingOrder }</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-shopping-cart fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-info shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-info text-uppercase mb-1">
												Đơn hàng đã hoàn thành</div>
											<div class="row no-gutters align-items-center">
												<div class="col-auto">
													<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${successOrder }</div>
												</div>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-box fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- Pending Requests Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-warning shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-warning text-uppercase mb-1">
												Tổng doanh thu</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${totalMoney }
												VNĐ</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Content Row -->
					<div class="row">
						<!-- DataTales Example -->
						<div class="card shadow mb-4 col-12 m-0 ml-auto mr-auto">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Danh sách
									khách hàng</h6>
							</div>

							<div class="card-body">
								<div class="table-wrapper-scroll-y my-custom-scrollbar">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<th>STT</th>
													<th>Tên khách hàng</th>
													<th>Địa chỉ</th>
													<th>Số điện thoại</th>
													<th>Trạng thái</th>
													<th></th>
												</tr>
											</thead>

											<c:set var="count" value="1" scope="page" />
											<c:forEach var="customer" items="${customers }">
											<c:url var="loadUpdateLink" value="cap-nhat-thong-tin">
												<c:param name="customerId" value="${customer.maKH}"/>
											</c:url>
											
												<tr>
													<td>${count}</td>
													<td>${customer.tenKH}</td>
													<td>${customer.diaChi}</td>
													<td>${customer.sdt}</td>
													
													<c:set var = "trangThai" value="${customer.trangThai}"/>
													<c:choose>
														<c:when test="${trangThai == 1}">
															<td><span class="text-success">Kích hoạt</span></td>
														</c:when>

														<c:otherwise>
															<td><span class="text-danger">Khóa</span></td>
														</c:otherwise>
													</c:choose>

													<td><a href="${loadUpdateLink }"
														class="btn btn-link p-0">Cập nhật</a></td>
												</tr>
												<c:set var="count" value="${count + 1}" scope="page" />
											</c:forEach>

										</table>
									</div>
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

	<jsp:include page="../includes/footer.jsp" />
</body>

</html>