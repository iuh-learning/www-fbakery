<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<!-- Title page -->
	<title><c:out value="${param.title }"></c:out></title>

	<!-- bootstrap-->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/vender/bootstrap/css/bootstrap.min.css">

	<!-- font awesome icon -->
	<link href="${pageContext.request.contextPath }/resources/vender/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	
	<!-- my css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/product.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/product_detail.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/product_payment.css">

	<!-- scripts -->
	<script src="${pageContext.request.contextPath }/resources/vender/jquery/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/vender/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/vender/bootstrap/js/bootstrap.bundle.min.js"></script>

</head>
