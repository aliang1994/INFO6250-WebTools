<%-- 
    Document   : searchdb
    Created on : Feb 24, 2018, 12:16:49 AM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1>Search Movie Database</h1>
        <form method="post" action="browse.htm">
            Keyword: <input type="text" name="querykw" required/><br/><br/>
            <input type ="radio" name="criteria" value="bytitle"/>Search by Title <br/><br/>
            <input type ="radio" name="criteria" value="byactor"/>Search by Actor <br/><br/>
            <input type ="radio" name="criteria" value="byactress"/>Search by Actress <br/><br/>
            <input type ="radio" name="criteria" value="bygenre"/>Search by Genre <br/><br/>
            <input type ="radio" name="criteria" value="byyear"/>Search by Year <br/><br/>
            <input type="submit" name="submit" value="Submit Query"/> 
        </form>
    </body>
</html>