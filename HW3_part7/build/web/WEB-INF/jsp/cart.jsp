<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shopping Cart</title>
</head>

<body>

	<nav>
            <a href="cart.htm?action=viewbooks">Books</a>
            <a href="cart.htm?action=viewmusic">Music</a>
            <a href="cart.htm?action=viewcomputer">Computers</a><br/><br/>
	</nav>
    

	<h1> View Shopping Cart </h1> <br/><br/>

	<form action ="cart.htm" method="post">
            <c:forEach items = "${sessionScope.mycart}" var="itemselected">   
                
                <input type='checkbox' name='selectedproduct' value="${itemselected}" />                 
                ${itemselected}  
                <br/>
            </c:forEach> 	<br/><br/>
                
            <input type='submit' name='action' value = 'delete' /> <br/>
	</form>
</body>
