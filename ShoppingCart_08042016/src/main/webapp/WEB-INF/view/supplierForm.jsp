<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Edit Form</title>
</head>
<body>
	<c:url value="create_supplier" var="url"></c:url>

<form:form method = "post" action="${url }" commandName="createSupplierObj">
<table>
			<tr>
				<td><form:label path="id">Supplier Id</form:label></td>
				<td><form:input path="id" disabled="true" class= "form-control" /> <form:hidden
						path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Supplier Name</form:label></td>
				<td><form:input path="name" class= "form-control" ></form:input></td>
			</tr>
			<tr>
				<td><form:label path="address">Supplier Address</form:label></td>
				<td><form:input path="address" class= "form-control" ></form:input></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Add Supplier"></td>
			</tr>
		</table>
		</form:form>
</body>
</html>