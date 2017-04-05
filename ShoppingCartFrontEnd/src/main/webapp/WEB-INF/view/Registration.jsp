<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<form action="create_user" method = "post" >

		User Id: <br>
		<input type="text" name="User Id"> <br><br>

		Password: <br>
		 <input type="password" name="Password"><br><br>

		Email Id: <br>
		 <input type="text" name="Email Id"><br><br>
		
		Contact No:<br>
		 <input type="text" name="Contact"><br><br> 
		
		Address: <br>
		 <input	type="text" name="Address"> <br><br> 
		
		<input type="submit" value="Register">

	</form>
</body>
</html>