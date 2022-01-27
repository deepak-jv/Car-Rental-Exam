<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error {
	color: red;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="navbar.jsp" ></jsp:include>



	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6" style="margin: 5px; border: 2px solid black">
			<br>
			<div style='background-color: blue'>
				<h3 style='color: white; text-align: center'>Register</h3>
			</div>
			<hr>
			<c:if test="${not empty error }">
			<div class="alert alert-danger">
			<c:out value="${error }"></c:out>
			</div>
			</c:if>
			<form:form  action="register" modelAttribute="customer_reg"
				method="POST">
				<table>

					<tr>
						<th>Name :</th>
						<td><form:input path="name" class="form-control"></form:input>
							<form:errors path="name" cssClass="error">
							</form:errors></td>
					</tr>
					<tr>
						<th>Contact :</th>
						<td><form:input path="contact" class="form-control" /> <form:errors
								path="contact" cssClass="error">
							</form:errors></td>
					</tr>
					<tr>
						<th>Email :</th>
						<td><form:input path="email" class="form-control" /> <form:errors
								path="email" cssClass="error">
							</form:errors></td>

					</tr>


					<tr>
						<th>Password :</th>
						<td><form:input path="password" class="form-control" /> <form:errors
								path="password" cssClass="error">
							</form:errors></td>
					</tr>




				</table>
				<br>
				<br>
				<input class="btn btn-primary" type="submit" value="register">
				<br>
				<br>
			</form:form>
			<p>
				if you are registered click <a href="login">login</a>
			</p>
		</div>
		<div class="col-md-3"></div>
	</div>







	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>