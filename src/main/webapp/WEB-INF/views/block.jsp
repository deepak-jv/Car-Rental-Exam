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
				<h2 style="color: white; text-align: center">Block Customer</h2>
			</div>
			<hr>
			<form:form action="blocked" modelAttribute="block"
				method="post">
				<table>

					<tr>
						<td><input class="form-control" type="text" name="name"
							value='<c:out value="${name}"></c:out>' readonly></td>
					</tr>
					
				</table>
				<br>
				<table style='margin-bottom: 10px'>
					<td><input class='btn btn-success' type="submit"
						value="Block"> <a class='btn btn-primary'
						href='report'>Back</a></td></td>
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