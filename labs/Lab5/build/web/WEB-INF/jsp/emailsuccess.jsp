<%-- 
    Document   : emailsuccess
    Created on : Feb 24, 2018, 11:29:38 PM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
         
             <p>${requestScope.message}</p>
        [<a href="${contextPath}/message/dashboard.htm">Dashboard</a>]
    </body>
</html>
