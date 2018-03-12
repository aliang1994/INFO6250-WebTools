<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shop for Books</title>


<body>

	<nav>
		<a href="books.jsp">Books</a>
		<a href="music.jsp">Music</a>
		<a href="computer.jsp">Computers</a> <br/><br/>
	</nav>

	<h1> Shop for Books </h1> <br/><br/>

	<form id="form" action="part7Servlet" method="get" >
		<input type = "checkbox" name="product" value="book1"/>  Book No.1     [$19.90]  <br/><br/>
		<input type = "checkbox" name="product" value="book2"/>  Book No.2     [$29.90]  <br/><br/>
		<input type = "checkbox" name="product" value="book3"/>  Book No.3     [$9.99]   <br/><br/>

		<input type = "submit" name="submit" value="Add to Cart"/> <br/><br/>
		<input type = "hidden" name="action" value="add"><br/><br/>

		<a href="cart.jsp">View Cart</a> <br/><br/>
	</form>


	

</body>
</head>