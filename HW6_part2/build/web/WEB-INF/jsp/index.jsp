<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML >

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSV Form</title>
    </head>

    <body>
        <form action="name.htm" method="post">
            <h2>Enter Filename Here:</h2> <br/>
            <input type="text" maxlength="20" name="filename" required />
            <input type="submit" name="action" value="Submit"/>
        </form>
        
        <form action="addrow.htm" method="post">
            <h2> Display Table Here </h2>
            <table border="2">
                <c:forEach items="${sessionScope.CSVData}" var="entry">
                <tr>
                    <c:forEach items="${entry.value}" var="value">
                    <td> ${value} </td>
                    </c:forEach>
                </tr>
                </c:forEach>
            </table>
            <input type="submit" name = "action" value="Insert Rows to Database">            
        </form>
        <br/><br/>
        
        <form action="display.xls" method="get">
            <input type="submit" name = "action" value="Download Page as Excel">
        </form>
        <br/><br/>
        
        
        <b>${sessionScope.DataCount}</b> rows inserted into the database
        <br/><br/>
        <br/><br/>
        <div>
            <a href="name.htm?pagenum=1"> 1  </a>   
            <a href="name.htm?pagenum=2"> 2  </a>   
            <a href="name.htm?pagenum=3"> 3  </a>   
            <a href="name.htm?pagenum=4"> 4  </a>
            <a href="name.htm?pagenum=5"> 5  </a>
            <a href="name.htm?pagenum=6"> 6  </a>
            <a href="name.htm?pagenum=7"> 7  </a>
            <a href="name.htm?pagenum=8"> 8  </a>
            <a href="name.htm?pagenum=9"> 9  </a>
            <a href="name.htm?pagenum=10"> 10  </a>
            <a href="name.htm?pagenum=11"> 11  </a>   
            <a href="name.htm?pagenum=12"> 12  </a>   
            <a href="name.htm?pagenum=13"> 13  </a>   
            <a href="name.htm?pagenum=14"> 14  </a>
            <a href="name.htm?pagenum=15"> 15  </a>
        </div>
    </body>
</html>