<%-- 
    Document   : goback
    Created on : Feb 25, 2018, 10:30:45 PM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
    </head>
    <body>
        <h1>${sessionScope.noBooks} books added successfully!</h1>
        
        <br/><br/>
        <a href="home.htm?action=back"> Click here to go back to home page </a> 
    </body>
</html>
