<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEAD -->
<jsp:include page="../../includes/head.jsp">
	<jsp:param value="Product" name="title" />
</jsp:include>

<body>
	<!-- Home page -->
	<div class="container-fluid mt-3">
		<div class="">
			<!-- HEARDER-->
			<jsp:include page="../../includes/header.jsp"></jsp:include>

			<!-- Scroll menu -->
			<jsp:include page="../../includes/scroll-menu.jsp"></jsp:include>
			<div class="row mt-4">
				<!-- Danh mục sản phẩm -->
				<div class="col-3">
					<div class="card list_product">
						<div class="card-header">
							<h5 class="text-center">Danh mục sản phẩm</h5>
						</div>
						<ul class="list-group option_product">
							<c:forEach var="item" items="${productType }">
								<li><a
									href='<c:url value="/product/${item.maLoaiSP }"></c:url>'
									class="list-group-item text-center">${item.tenLoaiSP }</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>

				<!-- List Products -->
				<div class="col-9">
					<h2 class="text-center fw-size">Danh Sách Các Sản Phẩm</h2>
					<div class="row ml-2">
						<c:forEach var="item" items="${product }">

							<c:if test="${item.trangThai == 1}">
								<div class="col-4 mt-4">
									<%-- <span>${item.value.loaiSP.maLoaiSP }</span> --%>
									<div class="card">
										<a
											href='<c:url value="/product-detail/${item.maSP }"></c:url>'><img style="width: 200px; height: 150px; border-radius: 8px;"
											class="mt-4 ml-4"
											src="${pageContext.request.contextPath }/../fbakery-admin/resources/img/${item.anh}"
											alt="" /></a>
										<div class="card-body">
											<a class="name_prod"
												href='<c:url value="/product-detail/${item.maSP }"></c:url>'>
												<h6 class="text-center">${item.tenSP }</h6>
											</a>
										</div>
										<div class="card-footer">
											<h5 class="product_price">Giá: ${item.donGia } đ</h5>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>

			<!-- Phân trang -->
			<div class="col-12 mt-4">
				<nav aria-label="Page navigation">
					<ul class="pagination justify-content-center">
						<li class="page-item disabled"><a class="page-link"
							aria-label="Previous" href="#"> <span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
						</a></li>
						<li class="page-item active"><a href="#" class="page-link">1</a></li>
						<li class="page-item"><a href="#" class="page-link">2</a></li>
						<li class="page-item"><a href="#" class="page-link">3</a></li>
						<li class="page-item"><a href="#" class="page-link">4</a></li>
						<li class="page-item"><a class="page-link" aria-label="Next"
							href="#"> <span aria-hidden="true">&raquo;</span> <span
								class="sr-only">Next</span>
						</a></li>
					</ul>
				</nav>
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