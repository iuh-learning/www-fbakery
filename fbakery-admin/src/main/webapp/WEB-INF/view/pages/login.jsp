<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../../includes/header.jsp">
	<jsp:param name="title" value="Admin - Login" />
</jsp:include>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
									</div>

									<form:form class="user" modelAttribute="userFormData"
										method="POST" action="check-login">
										<div class="form-group">
											<form:input path="userName"
												class="form-control form-control-user"
												placeholder="Enter username" />
										</div>
										<div class="form-group">
											<form:password path="password"
												class="form-control form-control-user" placeholder="Enter password"/>
										</div>
										
										<input class="btn btn-primary btn-user btn-block" type="submit" value="Login">
										
									</form:form>
									
									<hr>
									
									<c:if test="${param.status != null }">
										<div class="text-center">
										<h1 class="h4 text-danger mb-4">Login Fail!</h1>
									</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

	<jsp:include page="../../includes/footer.jsp" />

</body>

</html>