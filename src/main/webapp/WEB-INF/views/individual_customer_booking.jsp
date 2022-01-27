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
				<h3 style='color: white; text-align: center'>Booking</h3>
			</div>
			<hr>
			<c:if test="${not empty error }">
				<div class="alert alert-danger">
					<c:out value="${error }"></c:out>
					<a href="customer_registration">register</a> first for booking
				</div>
			</c:if>
			<form:form action="booking" modelAttribute="booking" method="post">
				<table>

					<tr>
						<th>Name :</th>
						<td><form:input path="name" class="form-control" /> <form:errors
								path="name" cssClass="error">
							</form:errors></td>
					</tr>
					<tr>
						<th>Contact :</th>
						<td><form:input path="contact" class="form-control" /> <form:errors
								path="contact" cssClass="error">
							</form:errors></td>
					</tr>
					<tr>
						<th>Address :</th>
						<td><form:input path="address" class="form-control" /> <form:errors
								path="address" cssClass="error">
							</form:errors></td>

					</tr>
			


					 <tr>
						<th>Select Car :</th>
						<td><form:select class="form-control" path="car">
								<option value="swift">Swift</option>
								<option value="thar">Thar</option>
								<option value="innova">Innova</option>
								<option value="fortuner">Fortuner</option>
							</form:select> <form:errors path="car" cssClass="error">
							</form:errors></td>
					</tr>

					 <tr>
						<th>Car Type :</th>
						<td><form:select class="form-control" path="carType">
								<option value="safari">Safari</option>
								<option value="a.c.">A.C</option>
								<option value="non a.c.">Non A.C.</option>
							</form:select> <form:errors path="carType" cssClass="error">
							</form:errors></td>
					</tr>
					 <tr>
						<th>Duration :</th>
						
						<td><form:select class="form-control" path="day">
								<option value="daily">Daily</option>
								<option value="weekly">Weekly</option>
								<option value="monthly">Monthly</option>
							</form:select> <form:errors path="day" cssClass="error">
							</form:errors></td>
					</tr>
					<tr>
						<th>Payment :</th>
						<td>

							<h6>Cash Payment</h6> <form:radiobutton path="payment"
								class="radio" value="Cash Payment" /> <form:errors
								path="payment" cssClass="error">
							</form:errors>

						</td>
						<td>

							<h6>Card Payment</h6> <form:radiobutton path="payment"
								class="radio" value="Card Payment" /> <form:errors
								path="payment" cssClass="error">
							</form:errors>

						</td>
					</tr>




				</table>
				<br>
				<br>
				<input class="btn btn-primary" type="submit" value="Book">
				<br>
				<br>
			</form:form>

		</div>
		<div class="col-md-3"></div>
	</div>







	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>

