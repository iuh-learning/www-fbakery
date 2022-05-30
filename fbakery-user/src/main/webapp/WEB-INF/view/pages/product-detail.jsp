<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!-- HEAD -->
<jsp:include page="../../includes/head.jsp">
	<jsp:param value="Product detail" name="title"/>
</jsp:include>

<body>

    <!-- Home page -->
    <div class="container-fluid mt-3">
        <div class="">
			<!-- HEARDER-->
            <jsp:include page="../../includes/header.jsp"></jsp:include>

            <!-- Scroll menu -->
            <jsp:include page="../../includes/scroll-menu.jsp"></jsp:include>
			
            <!-- Content -->
            <div class="row">
				<div class="col-6 mb-4 ">
					<img class="img_prod-detail"
						src="${pageContext.request.contextPath }/../fbakery-admin/resources/img/${productDetailById.anh}"
						alt="Ảnh bánh kem ..." style="width: 600px; margin: 140px 80px; border-radius: 10px;" />
				</div>
            	<div class="col-6">
				<!-- Load From Home Page To (maSP) -->
				<%-- Get Product By Id From Froduct Detail Controller --%>
				<h2 class="title_prod-detail mb-4 text-left">${productDetailById.tenSP }</h2>
				<h5>
					Giá chỉ còn: <b style="color: var(--primary-color);">${productDetailById.donGia }
						đ.</b>
				</h5>
				<%-- </c:forEach> --%>
				<div class="card left_card-prod-detail">
					<div class="card-header text-center">
						<b>Mua ngay để nhận các khuyến mãi đặc biêt của Fbakery</b>
					</div>
					<div class="card-content mt-2 ml-2">
						<p>1. Giao hàng đến tận nơi (miễn phí ship). Chỉ dành cho
							khách hàng đầu tiên.</p>
						<p>2. Hoàn trả tiền nếu sản phẩm không đạt chất lượng.</p>
						<p>3. Tặng kèm thêm "Bánh ngọt" của Shop.</p>
					</div>
				</div>
				<%-- Get Product By Id From Froduct Detail Controller --%>
				<div class="mt-2 d-flex">
					<form
						action='<c:url value="/add-cart/${productDetailById.maSP }"></c:url>'
						method="GET">
						<a href="http://localhost:8080/fbakery-user/product-cart">
							<button class="btn btn-success" style="width: 575px;" >Thêm vào giỏ hàng</button>
						</a>
					</form>
					<%-- <div class="ml-2">
						<a
							href='<c:url value="/pay-now/${productDetailById.maSP }"></c:url>'>
							<button class="btn btn-success">Mua ngay</button>
						</a>
					</div> --%>
				</div>
				<div class="col-8 mt-4" style="margin: 0px; padding: 0px;">
					<div class="card mb-4" style="width: 36rem;">
						<div class="card-header">
							<h3 class="text-center">Mô tả sản phẩm</h3>						
						</div>
						<div class="card-body">
							<p class="">${productDetailById.moTa }</p>							
						</div>
					</div>
				</div>
			</div>
            </div>

			<!-- Footer -->
		    <jsp:include page="../../includes/footer.jsp"></jsp:include>

            <!-- show arrow up -->
            <span class="show_arrow-up">
                <a href="#"><i class="fa-solid fa-arrow-up"></i></a>
            </span>
        </div>
    </div>
</body>

</html>