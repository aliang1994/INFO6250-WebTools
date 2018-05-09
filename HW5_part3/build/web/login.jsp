<%-- 
    Document   : login
    Created on : Mar 27, 2018, 8:20:33 AM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Admin Login Here: </h1>
        <form ACTION="j_security_check" METHOD="POST">
            User name: <INPUT TYPE="TEXT" NAME="j_username"></br></br>
            Password: <INPUT TYPE="PASSWORD" NAME="j_password"></br>
            <INPUT TYPE="SUBMIT" VALUE="Log In">
        </form>
    </body>
</html>
