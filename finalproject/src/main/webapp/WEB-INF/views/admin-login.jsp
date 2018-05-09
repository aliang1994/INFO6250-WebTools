<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>

	<h1>Admins Please Login Here: </h1>
        <form ACTION="j_security_check" METHOD="POST">
            User name: <INPUT TYPE="TEXT" NAME="j_username" required><br><br>
            Password: <INPUT TYPE="PASSWORD" NAME="j_password" required><br><br>
            
            <INPUT TYPE="SUBMIT" VALUE="Log In">
            <input type="reset"  value="Reset">
            
        </form>

</body>
</html>