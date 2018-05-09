<%-- 
    Document   : user-form
    Created on : Feb 24, 2018, 2:42:15 PM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:form commandName="userinfo" method="post"  enctype="multipart/form-data">
            First Name: <form:input path="firstname"   /><br/><br/>
            <input type="file" name="photo" /><br/>
            <input type="submit" value="Submit" />
        </form:form>
    </body>
</html>
