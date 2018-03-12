<%-- 
    Document   : searchresults
    Created on : Feb 24, 2018, 12:20:09 AM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        <h1>Search Results:</h1>
        <c:forEach items="${sessionScope.searchresult}" var="entry">            
                <c:forEach items="${entry.value}" var="value">
                    ${value} </br>
                </c:forEach>
                    </br> </br> </br> </br>

        </c:forEach>
        </br> </br>
        <a href="welcome.htm"> Click here to go back to home page </a> 
    </body>
</html>
