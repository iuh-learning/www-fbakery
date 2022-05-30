<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- Scroll menu -->
<div class="navbar row">
	<div class="col-6">
		<a href="#"> <img class="header_logo" src="${pageContext.request.contextPath }/resources/img/logo.png"
			alt="Logo Fbakery">
		</a>
	</div>
	<div class="col-6">
		<!-- <div class="toggle"></div> -->
		<ul class="menu_navbar d-flex justify-content-end mr-4 mt-2">
			<li><a href="http://localhost:8080/fbakery-user/" class="active">Trang chủ</a></li>
			<li><a href="http://localhost:8080/fbakery-user/product">Sản
					phẩm</a></li>
			<li><a href="http://localhost:8080/fbakery-user/product-payment">Đặt hàng</a></li>
			<li><a href="http://localhost:8080/fbakery-user/product-cart"
				class="myTooltip" data-toggle="tooltip" data-placement="bottom"
				title="Giỏ hàng"> <i class="fa-solid fa-cart-shopping"></i>
			</a></li>
			<!-- show Product + total price -->
			<span style="font-size: 12px;">
				<c:if test="${not empty Cart }">
					${TotalQuantyCart } sản phẩm - Tổng tiền: ${TotalPriceCart } đ.
				</c:if>
			</span>
		</ul>
	</div>
</div>