<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Bine ai venit in lumea Spring MVC!</h1>

	<P>Timpul pe server este: ${serverTime}.</p>

<%--	acesta este un action form care inregistreaza un user name--%>
    <form action="about" method="post">
        <input type="submit" value ="About">
    </form>
	<form action="user" method="post">
	    <P>Username:</p>
		<input type="text" name="userName"><br>
		<P>Email Address: </p>
		<input type="text" name="emailAddress"><br>
		<P>Phone Number: </p>
		<input type="text" name="phoneNumber"><br>
		<P>Date of Birth: </p>
		<input type="text" name="dateOfBirth"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>