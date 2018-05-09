<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<h1>Create New User Account</h1>
	<form action="${contextPath}/user/create.htm" method="POST"> 
		<table>
			<tr>
			    <td>NEW USERNAME:</td>
			    <td><input type="text" name="newusername"  maxlength="20" size="30" required="required" /></td>
			</tr>			
			<tr>
			    <td>NEW PASSWORD:</td>
			    <td><input type="password" name="newpassword"  maxlength="20" size="30" required="required"/></td>
			</tr>			
			<tr>
			    <td colspan="2"><input type="submit" value="Create Account" /></td>
			</tr>					
		</table>
	</form>
	
	<a href="${contextPath}/user/login.htm">Go to Login Page</a>
</body>
</html>