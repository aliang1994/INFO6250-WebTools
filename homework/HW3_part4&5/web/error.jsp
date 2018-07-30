<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<jsp:scriptlet>
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
</jsp:scriptlet>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>No option selected. please enter some inputs</h1>
        <a href='searchCourse.jsp'> Go Back To Search Page Again</a>
    </body>
</html>
