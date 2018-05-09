<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="admin-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Artist</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1>Artist deleted successfully!</h1>


<a href="${contextPath}/admin/music.htm">Go Back To View Artist</a>
</body>
</html>