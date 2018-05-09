<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="user-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Playlist</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1> Add New Playlist: </h1>
	<form method="post" action="${contextPath}/user/playlist/add.htm">
		<input type="text" name="playlistname" maxlength="40" required/>
		<input type="submit" name="action" value="Create Playlist" />
	</form>
	
	
</body>
</html>