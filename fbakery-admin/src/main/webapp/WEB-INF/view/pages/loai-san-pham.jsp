<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../includes/header.jsp">
	<jsp:param name="title" value="Admin - Product Type" />
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
					<div class="row mb-4 p-0">
						<div class="col-sm-3 col-xl-3">
							<a href="them-loai-san-pham" class="btn btn-primary w-auto">Thêm
								loại sản phẩm</a>
						</div>
					</div>

					<div class="row">
						<!-- DataTales Example -->
						<div class="card shadow mb-4 col-12 m-0 ml-auto mr-auto">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary">Danh sách
									loại sản phẩm</h6>
							</div>

							<div class="card-body">
								<div
									class="table-responsive table-wrapper-scroll-y my-custom-scrollbar">
									<table class="table table-bordered" id="dataTable" width="100%"
										cellspacing="0">
										<thead>
											<tr>
												<th>STT</th>
												<th>Tên loại sản phẩm</th>
												<th></th>
											</tr>
										</thead>

										<tbody>
											<c:set var="count" value="1" scope="page" />
											<c:forEach var="type" items="${typeProducts }">
												<c:url var="loadUpdate"
													value="cap-nhat-thong-tin-loai-san-pham">
													<c:param name="typeId" value="${type.maLoaiSP }" />
												</c:url>
												<tr>
													<td>${count}</td>
													<td>${type.tenLoaiSP }</td>
													<td><a href="${loadUpdate }" class="btn btn-link p-0">Cập
															nhật</a> <%-- <a href="${loadDelete }"
														class="btn btn-link text-danger p-0 ml-3">Xóa</a> --%></td>
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