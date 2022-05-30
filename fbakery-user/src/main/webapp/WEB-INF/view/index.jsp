<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HEAD -->
<jsp:include page="../includes/head.jsp">
	<jsp:param value="Home" name="title" />
</jsp:include>


<body>

	<!-- Home page -->
	<div class="container-fluid mt-3">
		<div class="">
			<!-- HEARDER-->
			<jsp:include page="../includes/header.jsp"></jsp:include>

			<!-- Scroll menu -->
			<jsp:include page="../includes/scroll-menu.jsp"></jsp:include>
			<div class="row">
				<!-- Content -->
			<div class="col-6">
				<div class="content">
					<div class="content_title">
						<h1>
							<p id="title_product-home"
								style="color: var(--primary-color); font-weight: 800">Bánh
								Anh Đào</p>
						</h1>
					</div>
					<div class="content_description">
						<p id="discription_product-home">Bánh ngon không sử dụng chất bảo quản, đảm bảo vệ sinh an toàn thực phẩm.</p>
					</div>
					<div class="content_btn-more">
						<li><a href="http://localhost:8080/fbakery-user/product">Xem
								ngay </a></li>
					</div>
				</div>
			</div>
			<div class="col-6">
				<img class="content_img"
					src="${pageContext.request.contextPath }/resources/img/banh-anh-dao-pi-day.jpg"
					alt="Ảnh bánh kem ..." />
			</div>	
			
			</div>

			<!-- Slides -->
			<div class="col-12">
				<ul class="slides">
					<li><img
						src="${pageContext.request.contextPath }/resources/img/banh-anh-dao-pi-day.jpg"
						onclick="changeImgs('${pageContext.request.contextPath }/resources/img/banh-anh-dao-pi-day.jpg'); changesTxtTitleProdGato();"></li>
					<li><img
						src="${pageContext.request.contextPath }/resources/img/banh-cupcake-muffin-banh-ngot-ngao.jpg"
						onclick="changeImgs('${pageContext.request.contextPath }/resources/img/banh-cupcake-muffin-banh-ngot-ngao.jpg'); changesTxtTitleProdNgot();"></li>
					<li><img
						src="${pageContext.request.contextPath }/resources/img/banh-kem-day-banh-dau-dau-tay-kem.jpg"
						alt="Ảnh bánh kem ..."
						onclick="changeImgs('${pageContext.request.contextPath }/resources/img/banh-kem-day-banh-dau-dau-tay-kem.jpg'); changesTxtTitleProdMan();"></li>
					<li><img
						src="${pageContext.request.contextPath }/resources/img/banh-mi-banh-ngot-banh-sung-bo.jpg"
						alt="Ảnh bánh kem ..."
						onclick="changeImgs('${pageContext.request.contextPath }/resources/img/banh-mi-banh-ngot-banh-sung-bo.jpg'); changesTxtTitleProdTiramisu();"></li>
					<li><img
						src="${pageContext.request.contextPath }/resources/img/banh-xeo-schaumomelette-op-let.jpg"
						alt="Ảnh bánh kem ..."
						onclick="changeImgs('${pageContext.request.contextPath }/resources/img/banh-xeo-schaumomelette-op-let.jpg'); changesTxtTitleProdPancake();"></li>
				</ul>
			</div>

			<!-- Space top hidden -->
			<div class="space"></div>

			<!-- Text Name List Product -->
			<h1 class="list_name-product mb-4 text-center w-100">Danh Sách
				Các Sản Phẩm</h1>

			<div class="row ml-5">
				<!-- Load List Products -> UI -->

				<c:forEach var="item" items="${products }">
					<c:if test="${item.trangThai == 1}">
						<div class="col-3">
							<div class="card mt-3 mb-5">
								<a href='<c:url value="/product-detail/${item.maSP }"></c:url>'><img style="width: 200px; height: 200px; border-radius: 8px;"
									src="${pageContext.request.contextPath }/../fbakery-admin/resources/img/${item.anh}"
									alt="" /></a>
								<div class="card-body">
									<a class="name_prod"
										href='<c:url value="/product-detail/${item.maSP }"></c:url>'>
										<h6 class="text-center">${item.tenSP }</h6>
									</a>
								</div>
								<div class="card-footer d-flex">
									<!-- <a href="#" class="btn btn-success">Thêm vào giỏ hàng</a> -->
									<h5 class="product_price">Giá: ${item.donGia } đ.</h5>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>

			</div>
		</div>

		<!-- Footer -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	</div>
</body>

</html>