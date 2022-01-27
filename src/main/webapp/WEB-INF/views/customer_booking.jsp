<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>



	<br>
	<div
		style='background-color: blue; margin-left: 2px; margin-right: 2px'>

		<h2 style="color: white; text-align: center">Bookings Report</h2>
	</div>
	<hr>
	<table class="table table-bordered table-hover table-dark"
		style="margin: 2px; margin-bottom: 10px">
		<thead>
			<tr>
				<th>Name</th>
				<th>Contact</th>
				<th>Address</th>
				<th>Car Name</th>
				<th>Car Type</th>
				<th>Duration</th>
				<th>Charge($/km)</th>
				<th>Payment</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="d" items="${data }">
				<tr>
					<td><c:out value="${ d.name}" /></td>

					<td><c:out value="${d.contact}" /></td>

					<td><c:out value="${d.address}" /></td>

					<td><c:out value="${d.car }" /></td>

					<td><c:out value="${d.carType }" /></td>

					<td><c:out value="${d.day }" /></td>

					<td><c:out value="${d.charge }" />$</td>

					<td><c:out value="${d.payment }" /></td>

					<td><c:out value="${d.status }" /></td>

					<td><a class="btn btn-danger">Cancel</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>