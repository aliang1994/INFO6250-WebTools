<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shopping Cart</title>


<body>

	<nav>
		<a href="books.jsp">Books</a>
		<a href="music.jsp">Music</a>
		<a href="computer.jsp">Computers</a> <br/><br/>
	</nav>


	<h1> View Shopping Cart </h1> <br/><br/>

	<form>

	<%
        HashMap <String, String> cart = (HashMap<String, String>)session.getAttribute("ShoppingCart");

            for (String prodname: cart.keySet()){  
            	out.println("<input type='checkbox' name='selectedproduct' value = '" + prodname + "' />");                              
                out.println(cart.get(prodname) + " <br/>" );                              
            }
        out.println("<input type='submit' name='action' value = 'delete' /> <br/>");    
        //<input type="hidden" name="action" value = "delete"/>
    %>
    	

	</form>





</body>
</head>