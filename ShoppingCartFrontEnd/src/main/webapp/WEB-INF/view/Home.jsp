<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Shop Easy!</title>
</head>
<body>
	<h2>
		<center>Shop Easy !</center>
	</h2>
	<center>${msg}</center>

	<center>${role}</center>

	<center>${successMessage }</center>

	<center>${errorMessage }</center>

	<center>${loginMessage }</center>
	<hr>
	<jsp:include page="CategoryMenu.jsp"></jsp:include>


	<c:if test="${isAdmin== true }">
		<jsp:include page="AdminHome.jsp"></jsp:include>
	</c:if>

	<c:if test="${empty loginMessage}">
		<a href="Login">Login</a>
		<a href="Registration">Register</a>
	</c:if>

	<c:if test="${not empty loginMessage}">
		<div align="right">
			<a href="Logout">Logout</a>
		</div>
		<br>
	</c:if>


	<c:if test="${isAdmin == false }">
		<a href="myCart">My Cart</a>
	</c:if>

	<!--  to display login page -->
	<c:if test="${isUserClickedLogin==true }">
		<jsp:include page="Login.jsp"></jsp:include>
	</c:if>

	<!-- To display registration page -->
	<c:if test="${isUserClickedRegister==true }">
		<jsp:include page="Registration.jsp"></jsp:include>
	</c:if>

	<!--  For users other than admin click on mycart -->
	<c:if test="${isUserClickedmyCart == true }">
		<jsp:include page="myCart.jsp"></jsp:include>
	</c:if>

	<!--  To go to badminton page -->
	<c:if test="${isUserClickedBadminton == true }">
		<jsp:include page="Badminton.jsp"></jsp:include>
	</c:if>
	
	<!--  To go to Cricket page -->
	<c:if test="${isUserClickedCricket == true }">
		<jsp:include page="Cricket.jsp"></jsp:include>
	</c:if>
	
	<!--  To go to football page -->
	<c:if test="${isUserClickedFootball == true }">
		<jsp:include page="Football.jsp"></jsp:include>
	</c:if>
	
	<!--  To go to golf page -->
	<c:if test="${isUserClickedGolf == true }">
		<jsp:include page="Golf.jsp"></jsp:include>
	</c:if>
	
	<!--  To go to Table Tennis page -->
	<c:if test="${isUserClickedTableTennis == true }">
		<jsp:include page="TableTennis.jsp"></jsp:include>
	</c:if>
	
	<!--  To go to basketball page -->
	<c:if test="${isUserClickedBasketball == true }">
		<jsp:include page="Basketball.jsp"></jsp:include>
	</c:if>


</body>
</html>