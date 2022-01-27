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


	<div class="row" style="margin-top: 10px; margin-bottom: 10px">
		<div class="col-md-3"></div>
		<div class="col-md-6" style="margin: 5px; border: 2px solid black">
			<br>
			<div style='background-color: blue'>
				<h3 style='color: white; text-align: center'>Avaliable Cars</h3>
			</div>
			<hr>
			<c:if test="${ not empty error }">
				<div class="alert alert-danger">
					<c:out value="${error}" />
				</div>
			</c:if>
			<form:form action='saveCar' modelAttribute="car" method="post">
				<table>

					<tr>
						<th>Select Cars :</th>
						<td>
						<form:select class="form-control" path="car">
								<option value="Swift">Swift</option>
								<option value="Thar">Thar</option>
								<option value="Innova">Innova</option>
								<option value="Fortuner">Fortuner</option>
							</form:select>
							</td>
					</tr>
					<br>
					<tr>
						<th>Car Type :</th>
						<td> <form:select
								class="form-control" path="carType">
								<option value="safari">Safari</option>
								<option value="a.c.">A.C</option>
								<option value="non a.c.">Non A.C.</option>
							</form:select></td>
					</tr>
				</table> 
				<br>
				<br>
				<input class="btn btn-success" type="submit" value="Add To Cart">
				<br>
			</form:form>
			<br>
			<br>
		</div>
		<div class="col-md-3"></div>
	</div>









	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>