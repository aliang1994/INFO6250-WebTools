<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="admin-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Song</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1> Song Deleted Successfully!</h1>

<a href="${contextPath}/admin/music/view.htm?artistid=${sessionScope.artistiddelete}">Go Back To Artist Info</a>
</body>
</html>