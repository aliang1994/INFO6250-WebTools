<%-- 
    Document   : addmovie
    Created on : Feb 24, 2018, 12:00:49 AM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri ="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Page</title>
    </head>
    <body>
        <h1>Add Movie to Database</h1>
        <p>Please enter the details of movie below: </p> <br/><br/>
        
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        
        <form:form action="${contextPath}/add.htm" commandName = "movie" method="post">
            Movie Title: <form:input path="title"/> <form:errors path="title"/><br/><br/>
            Lead Actor: <form:input path="leadactor"/> <form:errors path="leadactor"/><br/><br/>
            Lead Actress: <form:input path="leadactress"/> <form:errors path="leadactress"/><br/><br/>
            Genre: <form:input path="genre"/> <form:errors path="genre"/><br/><br/>
            Year: <form:input path="year"/> <form:errors path="year"/><br/><br/>

            <input type="submit" name="submit" value="Add Movie"/>
        </form:form>
    </body>
</html>