<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="admin-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Song</title>
</head>


<body>
	<h1>Add New Song</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	<form method="post" action="${contextPath}/admin/music/song/add.htm">
		Song Name: <input type="text" name="songname" maxlength="30" required/><br>
		Song URL: <input type="url" name="url" size="40" required/><br><br>
		<input type="submit" name="action" value="Create Song"/>
	</form>
	<br><br>
	
	<a href="${contextPath}/admin/music/view.htm?artistid=${sessionScope.artistid}">Go Back To Artist Info Page</a>
</body>
</html>