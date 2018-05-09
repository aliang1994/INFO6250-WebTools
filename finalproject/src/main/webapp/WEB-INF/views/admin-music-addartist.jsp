<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="admin-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Artist</title>
</head>


<body>
<h1>Add New Artist</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<form method="post" action="${contextPath}/admin/music/add.htm">
		<input type="text" name="artistname" maxlength="25" required/>
		<input type="submit" name="action" value="Create Artist"/>
	</form>
	<br><br>
	<a href="${contextPath}/admin/music.htm">Go Back To Artist List</a>
</body>
</html>