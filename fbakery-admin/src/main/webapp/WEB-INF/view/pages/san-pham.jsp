<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="../../includes/header.jsp">
	<jsp:param name="title" value="Admin - Product" />
</jsp:include>

<style>
.my-custom-scrollbar {
	position: relative;
	height: 550px;
	overflow: auto;
}

</style>
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
					<div class="row mb-4 p-0">
						<div class="col-sm-5 col-xl-5">
							<a href="them-san-pham" class="btn btn-primary w-auto">Thêm
								sản phẩm</a>
						</div>

						<div class="col-7 float-right">
							<form action="loc-san-pham"
								class="row justify-content-center align-items-center"
								method="post">
								<div class="col-xl-3 col-sm-3 ">Loại sản phẩm:</div>
								<select name="loai_san_pham" id="loaiSanPham"
									class="custom-select col-sm-6 col-xl-6">
									<option value="0">Lọc sản phẩm theo loại ...</option>
									<c:forEach var="_type" items="${types }">
										<option value="${_type.maLoaiSP }">${_type.tenLoaiSP }</option>
									</c:forEach>
								</select> <input type="submit" class="btn btn-info col-3 col-xl-3"
									value="Lọc">
							</form>
						</div>
					</div>

					<div class="row">
						<!-- DataTales Example -->
						<div class="card shadow mb-2 col-12 mt-0 md-0 ml-auto mr-auto">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Danh sách sản
									phẩm</h6>
							</div>

							<div class="card-body">
								<div
									class="table-responsive table-wrapper-scroll-y my-custom-scrollbar">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>STT</th>
												<th>Tên sản phẩm</th>
												<th class="w-25">Mô tả</th>
												<th>Ảnh</th>
												<th>Đơn giá</th>
												<th>Trạng thái</th>
												<th></th>
											</tr>
										</thead>

										<tbody>
											<c:set var="count" value="1" scope="page" />
											<c:forEach var="product" items="${products }">
												<tr>
													<c:url var="loadUpdateLink"
														value="cap-nhat-thong-tin-san-pham">
														<c:param name="productId" value="${product.maSP}" />
													</c:url>
													<td>${count}</td>
													<td>${product.tenSP }</td>
													<td>${product.moTa }</td>
													<td class="p-0"><img width="120px" height="100px"
														src="${pageContext.request.contextPath }/resources/img/${product.anh}"></td>
													<td>${product.donGia }đ</td>
													<td><c:if test="${product.trangThai == 1}">
															<p class="text-success">Mở bán</p>
														</c:if> <c:if test="${product.trangThai == 2}">
															<p class="text-danger">Hết hàng</p>
														</c:if></td>
													<td><a href="${loadUpdateLink}"
														class="btn btn-link p-0">Cập nhật</a></td>
												</tr>
												<c:set var="count" value="${count + 1}" scope="page" />
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