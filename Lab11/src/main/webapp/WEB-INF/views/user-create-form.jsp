<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<font color="red">${errorMessage}</font>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form action="${contextPath}/user/create.htm" method="POST">
		<table>
		<tr>
		    <td>User Email:</td>
		    <td><input type="text" name="username" size="30" required="required" /></td>
		</tr>
		
		<tr>
		    <td>Password:</td>
		    <td><input type="password" name="password" size="30" required="required"/></td>
		</tr>
		
		<tr>
				<td colspan="2">
				<label for="captchaCode" class="prompt">Retype the characters from the picture:</label> 
				<%
					// Adding BotDetect Captcha to the page
					Captcha captcha = Captcha.load(request,"CaptchaObject");
					captcha.setUserInputID("captchCode");
					
					String captchaHTML = captcha.getHtml();
					out.write(captchaHTML);					
				%> 
				<input id="captchaCode" type="text" name="captchaCode" required="required"/>
				</td>
			</tr>
		
		<tr>
		    <td colspan="2"><input type="submit" value="Login" /></td>
		</tr>
				
		</table>
	</form>
</body>
</html>