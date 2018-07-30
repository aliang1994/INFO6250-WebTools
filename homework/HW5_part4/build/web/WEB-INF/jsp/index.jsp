<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Book DB</title>
    </head>

    <body>
        <h1>How many books do you want to add?</h1>
        
        <form name='myForm' method="post" action="home.htm">
            <input type="number" name="noBooks" min="1" required/>
            <input type="submit" value="Submit"/>
        </form>
        
    </body>
</html>
