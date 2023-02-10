<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TO DO's APP</title>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	<style>
		#mybutton{
			float:right;
		}
	</style>
</head>
<body>
<div class="container">
	<h1 align="center" style="color:#337ab7">WELCOME TO MY TODO'S &nbsp; APPLICATION</h1>
	<hr>
	<div align="center">
	<button class="btn btn-primary mb-2" id="mybutton">
		<a href="/mytodos" style="color:white">ADD TODO'S</a>
	</button>
	</div>
	<hr>
	<c:if test="${not empty todosList}">
		<table class="table table-striped">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Task Name</th>
				<th scope="col">Status</th>
				<th scope="col">Edit</th>
				<th scope="col">Delete</th>
			</tr>
			<c:forEach var="listValue" items="${todosList}">
				<tr>
					<td class="table-primary">${listValue.id}</td>
					<td class="table-primary">${listValue.taskName}</td>
					<td class="table-danger">${listValue.status}</td>
					<td class="table-danger"><a href="editTodos/${listValue.id}">Edit</a></td>
					<td class="table-danger"><a href="deleteTodos/${listValue.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
</body>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
</html>