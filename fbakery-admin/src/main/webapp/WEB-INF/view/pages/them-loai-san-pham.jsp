<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../includes/header.jsp">
	<jsp:param name="title" value="Admin - Add Product Type" />
</jsp:include>
<style>
	.error{
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
					<div class="row">
						<!-- DataTales Example -->
						<div class="card shadow mb-4 col-10 m-0 ml-auto mr-auto">

							<div class="card-header">
								<h6 class="m-0 font-weight-bold text-primary">Thêm loại sản
									phẩm</h6>
							</div>

							<div class="card-body">
								<c:if test="${status != null}">
									<h6 class="ml-3 text-center text-danger">Loại sản phẩm bạn vừa nhập đã tồn tại!</h6>
								</c:if>
								<form:form action="luu-loai-san-pham" modelAttribute="type"
									method="GET" accept-charset="UTF-8">
									<form:hidden path="maLoaiSP"/>
									<div class="row col-12">
										<label for="">Tên loại sản phẩm:</label> 
										<form:input path="tenLoaiSP"
											class="form-control"/>
											<label><form:errors path="tenLoaiSP" class="error"/></label>
									</div>
									
									<div class="row col-12 mt-3">
										<input type="submit" class="btn btn-primary col-12"
											value="Xác nhận">
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