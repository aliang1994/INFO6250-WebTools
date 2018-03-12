<%-- 
    Document   : loginsucess
    Created on : Feb 17, 2018, 2:04:22 PM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
        <h1>Welcome ${sessionScope.username}</h1>
        [<a href ="${contextPath}/message/send.htm"> Send Message </a>]
        [<a href ="${contextPath}/message/display.htm"> Display Message </a>] <br/><br/>
        
        <form action ="${contextPath}/message/search.htm" method ="post">
            <input type ="text" name ="searchQuery"/>
            <input type="submit" value="Search Message"/>
        </form>
    </body>
</html>
