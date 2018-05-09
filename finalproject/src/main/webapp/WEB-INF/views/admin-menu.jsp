<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<a href="${contextPath}/admin/logout.htm">Admin Logout</a>
<a href="${contextPath}/admin/central.htm">Admin Home</a>
</body>
</html>