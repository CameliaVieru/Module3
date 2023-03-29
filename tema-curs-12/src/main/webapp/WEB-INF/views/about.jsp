<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>About Us</title>
</head>
<body>
<h3>Here is a short description about us</h3>
<P> This page is for training only. It represents the implementation of Spring MVC</p>
<h3>Contact details: </h3>
<P> Phone number: 1111 </p>
<P> Email Address: iamapotato@potato.com </p>
<P> Address: YES </p>
<P> Context Path: ${pageContext.request.contextPath}</p>
<font color="red">The Context Path is:<%=request.getContextPath()%></font>
<img src = "${pageContext.request.contextPath}/pegasus.jpg">
</body>
</html>


