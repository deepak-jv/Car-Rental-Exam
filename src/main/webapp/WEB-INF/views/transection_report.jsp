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
	<jsp:include page="navbar.jsp"></jsp:include>



	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6" style="margin: 5px; border: 2px solid black">
			<br>
			<div style='background-color: blue'>
				<h3 style='color: white; text-align: center'>Transection Report</h3>
			</div>
			<hr>
			<c:if test="${not empty success }">
				<div class="alert alert-success">
					<c:out value="${success }"></c:out>
				</div>
			</c:if>
			<table class="table">

				<tr>
					<td><input class="form-control" type="hidden" name="name"
						value='<c:out value="${id}"></c:out>'></td>
				</tr>

				<tr>
					<th>Name :</th>
					<td><c:out value="${name}"></c:out></td>
				</tr>
				<tr>
					<th>Contact :</th>
					<td><c:out value="${contact}"></c:out></td>
				</tr>
				<tr>
					<th>Address :</th>
					<td><c:out value="${address}"></c:out></td>
				</tr>
				<tr>
					<th>Car Name :</th>
					<td><c:out value="${car}"></c:out></td>
				</tr>
				<tr>
					<th>Car Type :</th>
					<td><c:out value="${carType}"></c:out></td>
				</tr>
				<tr>
					<th>Duration :</th>
					<td><c:out value="${day}"></c:out></td>
				</tr>
				<tr>
					<th>Charge :</th>
					<td><c:out value="${charge}$"></c:out></td>
				</tr>
				<tr>
					<th>Payment Mode:</th>
					<td><c:out value="${payment}"></c:out></td>
				</tr>
				<tr>
					<th>Status :</th>
					<td><c:out value="${status}"></c:out></td>
				</tr>




			</table>
			<br> <br> <a href="edit?id=${id}&carType=${carType}" class="btn btn-primary">Edit</a>
			<a href='customer_report?id=${id}&name=${name}' class="btn btn-success">Pay</a>
			<a href='delete_customer?id=${id}&name=${name}' class="btn btn-danger">Cancel</a>
			<br> <br>

		</div>
		<div class="col-md-3"></div>
	</div>







	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>

