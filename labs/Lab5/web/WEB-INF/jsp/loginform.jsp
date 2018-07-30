<%-- 
    Document   : login
    Created on : Feb 17, 2018, 2:08:06 PM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri ="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body>
        <h1>Login Form</h1>
        <form:form commandName = "login">
            User Name: <form:input path="username"/> <form:errors path="username"/><br/><br/>
            Password: <form:password path="password"/> <form:errors path="password"/><br/><br/>
            <input type="submit" value="Login"/>
        </form:form>
    </body>
</html>
