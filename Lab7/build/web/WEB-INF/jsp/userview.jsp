<%-- 
    Document   : userview
    Created on : Mar 3, 2018, 2:52:24 PM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User View Page</title>
    </head>
    <body>
        <h1>User Info</h1>
        User Id: ${requestScope.user.userId}<br />
        User name: ${requestScope.user.firstname} ${requestScope.user.lastname}<br />
        Courses: 
        <ul>      
            <c:forEach items="${requestScope.user.courses}" var="course">
                <li>${course}</li>
            </c:forEach>
           
        </ul>
    </body>
</html>
