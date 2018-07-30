<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Home Page</title>
</head>
<body>
	<h3>Welcome ${sessionScope.username}</h3>
	<h3>Id ${sessionScope.userid}</h3>
	<br>
	<table>
		<thead>
			<th>From</th>
			<th>Message</th>
			<th>MessageDate</th>
			<th>Delete</th>
			<th>Reply</th>
		</thead>
      <c:forEach items="${requestScope.messages}" var="msg" >
		<tr>
		<td>${msg.sender}</td>
		<td>${msg.messageString}</td>
		<td>${msg.messageDate}</td>
		<td><a href="../message/delete.htm?msgid=${msg.messageId}">Delete</a></td>
		<td>Reply</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>