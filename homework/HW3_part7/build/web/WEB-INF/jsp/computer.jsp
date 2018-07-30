<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shop for Computers</title>


<body>
	<nav>
            <a href="cart.htm?action=viewbooks">Books</a>
            <a href="cart.htm?action=viewmusic">Music</a>
            <a href="cart.htm?action=viewcomputer">Computers</a><br/><br/>
	</nav>

	<h1> Shop for Computers </h1> <br/><br/>

	<form action="cart.htm" method="post" >
		<input type = "checkbox" name="product" value="computer1"/>  Computer No.1     [$1990]  <br/><br/>
		<input type = "checkbox" name="product" value="computer2"/>  Computer No.2     [$2990]  <br/><br/>
		<input type = "checkbox" name="product" value="computer3"/>  Computer No.3     [$999]   <br/><br/>

		<input type = "submit" name="submit" value="Add to Cart"/> <br/><br/>
		<input type = "hidden" name="action" value="add"><br/><br/>

		<a href="cart.htm?action=viewcart">View Cart</a> <br/><br/>

	</form>

</body>
</head>