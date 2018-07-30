<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shop for Computers</title>


<body>
	<nav>
		<a href="books.jsp">Books</a>
		<a href="music.jsp">Music</a>
		<a href="computer.jsp">Computers</a> <br/><br/>
	</nav>

	<h1> Shop for Computers </h1> <br/><br/>

	<form id="form" action="part7Servlet" method="get" >
		<input type = "checkbox" name="product" value="computer1"/>  Computer No.1     [$1990]  <br/><br/>
		<input type = "checkbox" name="product" value="computer2"/>  Computer No.2     [$2990]  <br/><br/>
		<input type = "checkbox" name="product" value="computer3"/>  Computer No.3     [$999]   <br/><br/>

		<input type = "submit" name="submit" value="Add to Cart"/> <br/><br/>
		<input type = "hidden" name="action" value="add"><br/><br/>

		<a href="cart.jsp">View Cart</a> <br/><br/>

	</form>

</body>
</head>