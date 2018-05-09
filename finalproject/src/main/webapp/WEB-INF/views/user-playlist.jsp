<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="user-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Playlist</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1>My Playlist</h1>
	
	<table>		
		<c:forEach items="${sessionScope.currentlist}"  var="playlist">
		<tr>
			<td>${playlist.playlistid}</td>
			<td>${playlist.playlistname}</td>
			<td><a href="${contextPath}/user/playlist/view.htm?playlistid=${playlist.playlistid}">Go To Playlist</a></td>
			<!-- 
			<td><a href="${contextPath}/user/playlist/delete.htm?playlistiddelete=${playlist.playlistid}">Delete</a></td>
			 -->
		</tr>
		</c:forEach>
	</table>
	<br><br>
	
	
	<a href="${contextPath}/user/playlist/add.htm?userid=${sessionScope.currentuser.userid}">Add New Playlist</a>
	<a href="${contextPath}/user/login.htm">Go Back</a>

</body>
</html>