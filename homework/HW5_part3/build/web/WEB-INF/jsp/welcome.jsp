<%-- 
    Document   : welcome
    Created on : Feb 23, 2018, 11:23:26 PM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri ="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
        
        <h1>Welcome to the Movie Store!</h1><br/><br/>
        <p>Please choose your action below: </p><br/><br/>
        
        <form method="post" action="select.htm">
            <select name="selectmenu">
                <option value="browse">Browse Movies</option>
                <option value="add">Add New Movies</option>
            </select><br/><br/>
            <input type="submit" value="Go to Page"/>
        </form>
    </body>
</html>