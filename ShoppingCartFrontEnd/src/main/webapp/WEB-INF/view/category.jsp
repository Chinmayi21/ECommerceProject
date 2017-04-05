<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.
 com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Category Page</title>
</head>

<br>
<h2>Manage Categories</h2>
<br>

<a href="manage_category_create" class="btn btn-primary">Create
	category</a>
<br>
<br>

<!--  Displaying the different categories -->

<table border="1">
	<thead>
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Description</td>
			<td>Action</td>
		</tr>
	</thead>
	<c:forEach var="category" items="${categoryList }">
		<tr>
			<td>${category.id }&nbsp;&nbsp;</td>
			<td>${category.name }&nbsp;&nbsp;</td>
			<td>${category.description}&nbsp;&nbsp;</td>
			<td><a href="manage_category_edit/${category.id}">Edit</a> | <a
				href="manage_category_delete/${category.id }">Delete</a></td>
		<tr>
	</c:forEach>
</table>
</body>
</html>




