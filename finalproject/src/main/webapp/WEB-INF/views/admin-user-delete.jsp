<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="admin-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete User Account</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1> User Account Deleted Successfully! </h1>
<br>
<a href="${contextPath}/admin/user.htm">Go Back</a>
</body>
</html>