<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shop for Music</title>


<body>
	<nav>
		<a href="books.jsp">Books</a>
		<a href="music.jsp">Music</a>
		<a href="computer.jsp">Computers</a> <br/><br/>
	</nav>

	<h1> Shop for Music </h1> <br/><br/>

	<form id="form" action="part7Servlet" method="get" >
		<input type = "checkbox" name="product" value="music1"/>  Music No.1     [$1.99]  <br/><br/>
		<input type = "checkbox" name="product" value="music2"/>  Music No.2     [$2.90]  <br/><br/>
		<input type = "checkbox" name="product" value="music3"/>  Music No.3     [$0.99]  <br/><br/>

		<input type = "submit" name="submit" value="Add to Cart"/> <br/><br/>
		<input type = "hidden" name="action" value="add"><br/><br/>

		<a href="cart.jsp">View Cart</a> <br/><br/>

	</form>
</body>
</head>