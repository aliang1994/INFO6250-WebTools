<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shop for Music</title>


<body>
	<nav>
            <a href="cart.htm?action=viewbooks">Books</a>
            <a href="cart.htm?action=viewmusic">Music</a>
            <a href="cart.htm?action=viewcomputer">Computers</a><br/><br/>
	</nav>

	<h1> Shop for Music </h1> <br/><br/>

	<form action="cart.htm" method="post" >
		<input type = "checkbox" name="product" value="music1"/>  Music No.1     [$1.99]  <br/><br/>
		<input type = "checkbox" name="product" value="music2"/>  Music No.2     [$2.90]  <br/><br/>
		<input type = "checkbox" name="product" value="music3"/>  Music No.3     [$0.99]  <br/><br/>

		<input type = "submit" name="submit" value="Add to Cart"/> <br/><br/>
		<input type = "hidden" name="action" value="add"><br/><br/>

		<a href="cart.htm?action=viewcart">View Cart</a> <br/><br/>
	</form>
</body>
</head>
