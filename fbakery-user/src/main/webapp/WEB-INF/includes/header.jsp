<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- HEADER -->

<div class="row">
	<div class="col-4">
		<a href="http://localhost:8080/fbakery-user/"> <img
			class="header_logo"
			src="${pageContext.request.contextPath }/resources/img/logo.png"
			alt="Logo Fbakery">
		</a>
	</div>
	<!-- Menu -->
	<div class="col-8">
		<ul class="menu float-right">
			<li><a href="http://localhost:8080/fbakery-user/" class="">Trang
					chủ</a></li>
			<li><a href="http://localhost:8080/fbakery-user/product">Sản
					phẩm</a></li>
			<li><a href="http://localhost:8080/fbakery-user/product-payment">Đặt hàng</a></li>
			<li><a href="http://localhost:8080/fbakery-user/product-cart"
				class="myTooltip" data-toggle="tooltip" data-placement="bottom"
				title="Giỏ hàng"> <i class="fa-solid fa-cart-shopping"></i>
			</a> <!-- show Product + total price --> <span style="font-size: 12px;">
					<c:if test="${not empty Cart }">
					${TotalQuantyCart } sản phẩm - Tổng tiền: ${TotalPriceCart } đ.
				</c:if>
			</span></li>
		</ul>
	</div>
</div>