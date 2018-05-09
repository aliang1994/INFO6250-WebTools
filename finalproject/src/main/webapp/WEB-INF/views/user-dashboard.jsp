<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="user-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Dashboard</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1> User Dashboard</h1>
	<h2> Welcome, ${sessionScope.currentuser.username} ! </h2>
	
	<p>Search for Music:</p>
	<form action="${contextPath}/user/search.htm" method="post">
	
		<input type="text" name="keyword"  placeholder="Search Song Here" required/>
		
		<br> <br>
		<input type="submit" name="submit" value="Search" />
	</form>


	
</body>
</html>