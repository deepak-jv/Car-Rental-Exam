<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="navbar.jsp"></jsp:include>




	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6" style="margin: 5px; border: 2px solid black">
			<br>
			<div style='background-color: blue'>
				<h2 style="color: white; text-align: center">Update Product</h2>
			</div>
			<hr>
			<form:form action="update_product" modelAttribute="data"
				method="post">
				<table>

					<tr>
						<td><input class="form-control" type="hidden" name="id"
							value='<c:out value="${id}"></c:out>'></td>
					</tr>
					<tr>
						<th>Name :</th>
						<td><input class="form-control" type="text" name="name"
							value='<c:out value="${name}"></c:out>'></td>
					</tr>
					<tr>
						<th>Address</th>
						<td><input class="form-control" type="text" name="address"
							value='<c:out value="${address}"></c:out>'></td>

					</tr>
					<tr>
						<th>Contact :</th>
						<td><input class="form-control" type="text" name="contact"
							value='<c:out value="${contact}"></c:out>'></td>
					</tr>
					<tr>
						<th>Car :</th>
						<td><select class="form-select form-select-lg" name="car">
								<option><c:out value="${car}"></c:out></option>
								<option>innova</option>
								<option>fortuner</option>
								<option>swift</option>
								<option>thar</option>

						</select></td>
					</tr>
					<tr>
						<th>Car Type :</th>
						<td><select class="form-select form-select-lg" name="carType">
								<option><c:out value="${carType}"></c:out></option>
								<option>safari</option>
								<option>a.c.</option>
								<option>non a.c.</option>

						</select></td>
					</tr>
					<th>Duration :</th>

					<td><select class="form-select form-select-lg"  name="day">
							<option><c:out value="${day}"></c:out></option>
							<option value="daily">Daily</option>
							<option value="weekly">Weekly</option>
							<option value="monthly">Monthly</option>
						</select> <form:errors path="day" cssClass="error">
						</form:errors></td>
					</tr>
					<tr>
						<th>Payment Mode :</th>
						<td><select class="form-select form-select-lg" name="payment">
								<option><c:out value="${payment}"></c:out></option>
								<option>Cash Payment</option>
								<option>Card Payment</option>



						</select></td>
					</tr>

					<tr>
						<th>Charge :</th>

						<td class="form-control" readonly><c:out value="${charge}$"></c:out></td>
					</tr>

					<tr>
						<th>Status :</th>
						<td><input class="form-control" type="text" name="status"
							value='<c:out value="${status}"></c:out>' readonly></td>
					</tr>
					<tr>
				</table>
				<br>
				<table style='margin-bottom: 10px'>
					<td><input class='btn btn-success' type="submit"
						value="Update"> <a class='btn btn-primary'
						href='customer_report?id=${id}&name=${name}'>Back</a></td>
				</table>

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