<%@page import="com.java.spring.model.BlockedCustomers"%>
<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.java.spring.dao.BlockedCustomerDao" %>
<%@page import="com.java.spring.dao.BlockedCustomerDaoImpl" %>
<%@page import="java.util.List" %>
<%@page import="com.java.spring.model.BlockedCustomers" %>

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

<jsp:include page="navbar.jsp" ></jsp:include>

<c:if test="${not empty msg }">

<div class="alert alert-success"><c:out value="${msg }"></c:out> 

 </div>
</c:if>
	<br>
	<div style='background-color:blue;margin-left:2px;margin-right:2px'>
	
		<h2 style="color: white; text-align: center">Booking Reports</h2>
	</div>
	<hr>
	<table class="table table-bordered table-hover table-dark"
		style="margin: 2px; margin-bottom: 10px">
		<thead>
			<tr>
				<th> Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Contact</th>
				<th>Car Name</th>
				<th>Car Type</th>
				<th>Duration</th>
				<th>Charge($/km)</th>
				<th>Payment Mode</th>
				<th>Status</th>
				<th>Actions</th>
			</tr>
		</thead>

		<tbody>
	
			<c:forEach items="${reports}" var="e">
				<c:if test="${e.name}"></c:if>
				<tr>
					<td><c:out value="${e.id }" /></td>

					<td><c:out value="${e.name}" /></td>
				
					<td><c:out value="${e.address }" /></td>
				
					<td><c:out value="${e.contact }" /></td>
				
					<td><c:out value="${e.car }" /></td>
					
					<td><c:out value="${e.carType }" /></td>

					<td><c:out value="${e.day }" /></td>
					
					<td><c:out value="${e.charge }" />$</td>
					
					<td><c:out value="${e.payment }" /></td>
					
					<td><c:out value="${e.status }" /></td>
			
					<%-- <td><a href="edit?id=${e.id}&carType=${e.carType}" class="btn btn-primary">Edit</a> --%>
					<td><a href="delete?id=${e.id}&carType=" class="btn btn-danger">Cancel</a>
					
					<a href="block?id=${e.id}&name=${e.name}" class="btn btn-warning">Block</a>
					
					<%-- <a href="unblock?id=${e.id}&name=${e.name}" class="btn btn-success">Unblock</a> --%>
					
				




					</td>
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