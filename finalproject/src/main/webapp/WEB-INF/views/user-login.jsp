<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script>
	function ajaxEvent() {

    var xmlHttp;
    try // Firefox, Opera 8.0+, Safari
    {
        xmlHttp = new XMLHttpRequest();
    } catch (e) {
        try // Internet Explorer
        {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("Your browser does not support AJAX!");
                return false;
            }
        }
    }

    xmlHttp.onreadystatechange = function() {
        if (xmlHttp.readyState == 4) {
            document.getElementById("info").innerHTML = xmlHttp.responseText;
        }
    }
    
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    xmlHttp.open("POST", "../ajaxservice.htm?username="+username+"&password="+password, true);
    xmlHttp.send();
}
</script>
	<title>App Home</title>
</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h1> Simplified Web Music Player </h1>
<form action="${contextPath}/user/login.htm" method="POST"> 
		<table>
		<tr>
		    <td>USERNAME:</td>
		    <td><input type="text" name="username" id="username" maxlength="20" size="30" required="required" /></td>
		</tr>
		
		<tr>
		    <td>PASSWORD:</td>
		    <td><input type="password" name="password" id="password" maxlength="20" size="30" required="required"/></td>
		</tr>
		
		<tr>
		    <td colspan="2"><input type="submit" name="action" value="Login" /></td>
		</tr>
				
		</table>
	</form>
	<br><br>
	<div id="info"></div>
	<br><br><br><br>
	
	<a href="${contextPath}/user/create.htm">Create New User Account</a>
	
	<br>
	<a href="${contextPath}/admin/central.htm">I am a System Admin</a>
	

</body>
</html>
