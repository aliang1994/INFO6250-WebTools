<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="user-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Song to Playlist</title>
</head>


<body>
<h1>Add To Playlist</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<form action="${contextPath}/user/playlist/addsong.htm" method="post">
	<table>
		<c:forEach items="${sessionScope.currplaylists}" var="playlist">
			<tr>
				<td><input type="radio" name="hiddenid" value="${playlist.playlistid}" required/></td>
				<td>${playlist.playlistid} </td>
				<td>${playlist.playlistname}</td>				
				<td></td>				
			</tr>
		</c:forEach>
	</table> <br><br>
	<input type="submit" name="action" value="add"/>
</form>
	
</body>
</html>