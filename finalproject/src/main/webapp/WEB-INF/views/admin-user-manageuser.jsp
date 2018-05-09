<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="admin-menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1>Manage User Account</h1>
	<table>
		<tr>
			<th>user id</th>
			<th>username</th>
			<th>password</th>
			<th> </th>
		</tr>
		<c:forEach items="${sessionScope.userlist}"  var="user">
		<tr>
			<td>${user.userid}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td><a href="${contextPath}/user/delete.htm?userid=${user.userid}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>