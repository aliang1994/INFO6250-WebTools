<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shop for Books</title>


<body>

	<nav>
            <a href="cart.htm?action=viewbooks">Books</a>
            <a href="cart.htm?action=viewmusic">Music</a>
            <a href="cart.htm?action=viewcomputer">Computers</a><br/><br/>
	</nav>

	<h1> Shop for Books </h1> <br/><br/>

	<form  action="cart.htm" method="post" >
		<input type = "checkbox" name="product" value="book1"/>  Book No.1     [$19.90]  <br/><br/>
		<input type = "checkbox" name="product" value="book2"/>  Book No.2     [$29.90]  <br/><br/>
		<input type = "checkbox" name="product" value="book3"/>  Book No.3     [$9.99]   <br/><br/>

		<input type = "submit" name="submit" value="Add to Cart"/> <br/><br/>
		<input type = "hidden" name="action" value="add"><br/><br/>

		<a href="cart.htm?action=viewcart">View Cart</a> <br/><br/>
	</form>


	

</body>
</head>