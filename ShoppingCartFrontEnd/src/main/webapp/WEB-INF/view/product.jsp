<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.
 com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Product Page</title>
</head>
<body>
<br>
<h2>Manage Products</h2>
 
<br>

<a href="manage_product_create" class="btn btn-primary"> Create Product</a> <br> <br>

<!--  Displaying the different products -->

<table border = "1">
			<thead>
				<tr>
					<td>Product Image</td>
					<td>Id</td>
					<td>Name</td>
					<td>Price</td>
					<td>Supplier Name</td>
					<td>Category Name </td>
					<td> Action</td>
				</tr>
			</thead>
			
<c:forEach var="product" items="${productList }">
			<tr>
			
			<td><c:url value="/resources/images/${product.id}.png" var= "src"/>
			<img src=${src } style="width:70px" align = "middle"/></td>
				<td>${product.id }&nbsp; &nbsp;</td>
				<td>${product.name } &nbsp; &nbsp;</td>
				<td>${product.price}&nbsp; &nbsp;</td>
				<td>${product.supplier.name }</td>
				<td>${product.category.name}</td>
				<td><a href="manage_product_edit/${product.id}">Edit</a> | <a href= "manage_product_delete/${product.id}">Delete</a></td>
				
			<tr>
				</c:forEach>
		</table>

</body>
</html>