<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/tlds/TagLibrary.tld"%>
<!DOCTYPE HTML>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <form action="name.htm" method="post">
            <h2>Enter Filename Here:</h2> <br/>
            <input type="text" name="filename"/>
            <input type="submit" name="action" value="Submit"/>
        </form>
        
        <form action="addrow.htm" method="post">
            <h2> Display Table Here </h2>
            <mytag:HomeTagHandler filename="${sessionScope.filename}"></mytag:HomeTagHandler>
            <input type="submit" value="Insert Rows to Database">
        </form>
        <br/>
        <b>${sessionScope.DataCount}</b> rows inserted into the database
    </body>
</html>