<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
	
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../includes/header.jsp">
	<jsp:param name="title" value="Admin - Update Customer" />
</jsp:include>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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

							<div class="card-header pb-0">
								<h6 class="font-weight-bold text-primary ml-2">Cập nhật
									thông tin khách hàng</h6>
							</div>

							<div class="card-body">
								<form:form action="luu-thong-tin-khach-hang"
									modelAttribute="customer" method="GET" accept-charset="UTF-8">
									<form:hidden path="maKH"/>
									<div class="row col-12 ml-auto mr-auto">
										<label for="">Tên khách hàng:</label>
										<form:input path="tenKH" class="form-control"/>
									</div>

									<div class="row col-12 ml-auto mr-auto mt-2">
										<label for="">Địa chỉ:</label>
										<form:input path="diaChi" class="form-control"/> 
									</div>

									<div class="row col-12 ml-auto mr-auto mt-2">
										<label for="">Số điện thoại:</label> 
										<form:input path="sdt" class="form-control"/> 
									</div>

									<div class="row col-12 ml-auto mr-auto mt-2">
										<label for="">Trạng thái:</label> 
										<form:select path="trangThai" class="custom-select">
											<form:option value="1">Kích hoạt</form:option>
											<form:option value="0">Khóa</form:option>
										</form:select>
										
									</div>


									<div class="row col-12 mt-3 ml-auto mr-auto">
										<input type="submit" class="btn btn-primary col-12"
											value="Cập nhật">
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