<%-- 
    Document   : userview
    Created on : Feb 10, 2018, 2:00:03 PM
    Author     : Wenqing
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <h1>User View</h1>
        <table border ="1">
            <tr>
                <th> User ID </th>
                <th> First Name </th>
                <th> Last Name </th>
                <th> Email </th>
            </tr>
            <c:forEach items="${requestScope.userlist}" var = "user">
                <tr>
                    <th> ${user.userid} </th>
                    <th> ${user.firstname} </th>
                    <th> ${user.lastname} </th>
                    <th> ${user.email} </th>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
