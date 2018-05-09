<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="user-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1>Search Result</h1>
	
    <c:set var ="result" value="${sessionScope.result}"/>
    
    <c:if test="${empty sessionScope.result}">
    	<p>Sorry, no results can be found by this criteria.</p>
    </c:if>    	
    	
    <table>
		<c:forEach items="${sessionScope.result}" var="song">
			<tr>
				<td>${song.songid} </td>
				<td>${song.songname}</td>											
				<td><a href="${song.url}">Go To Song</a></td>	
				<td><a href="${contextPath}/user/playlist/addsong.htm?songid=${song.songid}">Add to Playlist</a></td>							
			</tr>
		</c:forEach>
	</table>  
	

</body>
</html>