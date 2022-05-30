<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../includes/header.jsp">
	<jsp:param name="title" value="Admin - Add Product" />
</jsp:include>
<style>
.error {
	font-size: 15px;
	color: red
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
					<div class="row m-0">
						<!-- DataTales Example -->
						<div class="card shadow mb-4 col-10 m-0 ml-auto mr-auto pb-4">

							<div class="card-header pb-1">
								<div class="row">
									<h6 class="font-weight-bold text-primary ml-2">Thêm sản
										phẩm</h6>
								</div>
							</div>

							<div class="card-body">
								<c:if test="${param.name != null}">
									<h6 class="ml-3 text-center text-danger">Sản phẩm bạn vừa
										nhập đã tồn tại</h6>
								</c:if>
								<c:if test="${param.status != null}">
									<h6 class="ml-3 text-center text-danger">Vui lòng chọn
										loại sản phẩm</h6>
								</c:if>
								<c:if test="${param.decimal != null}">
									<h6 class="ml-3 text-center text-danger">Đơn giá phải lớn hơn 10000</h6>
								</c:if>
							</div>
							
							<form:form action="luu-san-pham" modelAttribute="product"
								method="POST" enctype="multipart/form-data">
								<form:hidden path="maSP" />

								<div class="row col-12 ml-auto mr-auto">
									<label for="">Tên sản phẩm:</label>
									<form:input path="tenSP" class="form-control" />
									<label><form:errors path="tenSP" class="error" /></label>
								</div>

								<div class="row col-12 ml-auto mr-auto mt-2">
									<label for="">Loại sản phẩm:</label> <select
										name="idTypeProduct" class="custom-select">
										<option value="0">Chọn loại sản phẩm</option>
										<c:forEach var="_type" items="${types }">
											<option value="${_type.maLoaiSP }">${_type.tenLoaiSP }</option>
										</c:forEach>
									</select>
								</div>

								<div class="row col-12 ml-auto mr-auto  mt-2">
									<label for="" class="row col-12">Ảnh:</label>
									<div class="row col-12 p-0">
										<div class="col-12">
											<form:input path="image" type="file"
												class="form-control-file" />
										</div>
									</div>
								</div>

								<div class="row col-12 ml-auto mr-auto  mt-2">
									<label for="">Đơn giá:</label>
									<form:input path="donGia" class="form-control" />
								</div>


								<div class="row col-12 ml-auto mr-auto  mt-2">
									<label for="">Mô tả:</label>
									<form:textarea path="moTa" class="form-control" rows="6"/>
									<label><form:errors path="moTa" class="error" /></label>
								</div>

								<div class="row col-12 ml-auto mr-auto mt-2">
									<label for="">Trạng thái:</label>
									<form:select path="trangThai" class="custom-select">
										<form:option value="0">Chọn trạng thái sản phẩm</form:option>
										<form:option value="1">Mở bán</form:option>
										<form:option value="2">Hết hàng</form:option>
									</form:select>
									<label><form:errors path="trangThai" class="error" /></label>
								</div>

								<div class="row col-12 mt-3 ml-auto mr-auto">
									<input type="submit" class="btn btn-primary col-12"
										value="Thêm">
								</div>

							</form:form>
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