<%-- 
    Document   : addBook
    Created on : Feb 25, 2018, 10:23:02 PM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <h1>Add Book to Database</h1>
        <form method="post" action="book.htm">         
            <table style="text-align: center">                
                <tr>
                    <th>ISBN</th>
                    <th>Book Title</th> 
                    <th>Authors</th>
                    <th>Price</th>
                </tr>
           
                <c:forEach begin="1" end="${sessionScope.noBooks}" var="val">
                    <tr>
                        <td><input type="text" id="isbn" name="isbn${val}"  required></td>
                        <td><input type="text" id="bookTitle" name="bookTitle${val}" size="20" required></td>
                        <td><input type="text" id="authors" name="authors${val}" size="20" required></td>
                        <td><input type="number" id="price" name="price${val}" size="20" step="0.01" required></td>
                    </tr>
                </c:forEach>
            </table>                
            <br/>
            <input type="submit" value="Add Books">
        </form>
    </body>
</html>
