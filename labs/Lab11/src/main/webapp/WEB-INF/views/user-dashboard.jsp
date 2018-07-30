<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
            document.getElementById("coursediv").innerHTML = xmlHttp.responseText;
        }
    }
    
    var queryString = document.getElementById("queryString").value;

    xmlHttp.open("POST", "../ajaxservice.htm?course="+queryString, true);
    xmlHttp.send();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>
	Search Courses:
	<input type="text" id="queryString" size="30" onkeyup="ajaxEvent()" />

	<div id="coursediv">
		
	</div>

</body>
</html>