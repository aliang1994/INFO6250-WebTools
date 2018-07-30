<%@ page import="java.util.*"%>
<!-- <%@ page import="java.io.IOException"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%> -->


<html>
<head>
	<title> request headers</title>
</head>
<body bgcolor="pink">
	<h1> Print out all of the request headers using JSP: </h1>


<table>
	<% 
		Enumeration<String> allheaders = request.getHeaderNames();
		while(allheaders.hasMoreElements()){
	        String headername = allheaders.nextElement();
	        String values = request.getHeader(headername);
	                
	%>


	<tr>
		<td><%= headername %></td>
		<td><%= values %></td>
	</tr>

	<%
		}
	%>
</table>



</body>
</html>