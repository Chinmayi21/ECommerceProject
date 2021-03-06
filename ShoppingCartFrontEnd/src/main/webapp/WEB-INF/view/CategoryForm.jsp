<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<title>Insert title here</title>
</head>
<body>

	<c:url value="manage_category_create" var="url"></c:url>

	<form:form method="post" action="${url}" commandName="createCategoryObj">
		<table>
			<tr>
				<td><form:label path="id">Category Id</form:label></td>
				<td><form:input path="id" disabled="true" class="form-control"></form:input></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Category Name</form:label></td>
				<td><form:input path="name" class="form-control"></form:input></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Category Description</form:label></td>
				<td><form:input path="description"  class="form-control"></form:input></td>
				<td><form:errors path="description" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add Category"
					class="btn btn-default"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>