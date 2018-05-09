<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="admin-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Artist</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1>Artist Info Page</h1>
	Artist ID: ${sessionScope.artist.artistid} <br>
	Artist Name: ${sessionScope.artist.artistname} <br>
	Songs:
	<table>
		<c:forEach items="${sessionScope.artist.songlist}" var ="song">
			<tr>
				<td>${song.songid} </td>
				<td>${song.songname}</td>											
				<td><a href="${song.url}">Go To Song</a></td>				
				<td><a href="${contextPath}/admin/music/song/delete.htm?artistiddelete=${artist.artistid}&songid=${song.songid}">Delete Song </a></td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	
	<a href="${contextPath}/admin/music/song/add.htm?artistid=${artist.artistid}">Add New Song</a>

</body>
</html>