<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="user-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Playlist Details</title>
</head>


<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1>Playlist Details</h1>
	${sessionScope.playlist.playlistid}
	${sessionScope.playlist.playlistname}<br>	
	<table>		
		<c:forEach items="${sessionScope.songlist}"  var="song">
		<tr>
			<td>${song.songid}</td>
			<td>${song.songname}</td>
			<td><a href="${song.url}">Go To Song</a></td>	
			<!--  			
			<td><a href="${contextPath}/user/playlist/deletesong.htm?playlistdelete=${sessionScope.playlist.playlistid}&songiddelete=${song.songid}">Delete Song </a></td>		
			-->	
		</tr>
		</c:forEach>
	</table>
	<br><br>

</body>
</html>