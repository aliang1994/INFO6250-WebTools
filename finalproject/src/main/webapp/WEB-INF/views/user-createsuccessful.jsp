<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2>New User Account Created Successfully!</h2>

<a href="${contextPath}/user/login.htm">Go to Login Page</a>
</body>
</html>