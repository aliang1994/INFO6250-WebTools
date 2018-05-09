<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="admin-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Database</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1>Manage Music Database</h1>

	<table>		
		<c:forEach items="${sessionScope.artistlist}"  var="artist">
		<tr>
			<td>${artist.artistid}</td>
			<td>${artist.artistname}</td>
			<td><a href="${contextPath}/admin/music/view.htm?artistid=${artist.artistid}">Go To Artist</a></td>
			<td><a href="${contextPath}/admin/music/delete.htm?artistid=${artist.artistid}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	<br><br>
	
	<a href="${contextPath}/admin/music/add.htm">Add New Artist</a>

</body>
</html>