<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Error Page</h1>
<p>${errorMessage}</p>

<c:if test = "${resendLink== true}" >
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<form action="${contextPath}/user/resendemail.htm" method="POST">
		User Email:<input type="text" name="username" size="30" required="required" />
		<br/>
		<input type="submit" value="Resend Email" />
	</form>	
</c:if>

</body>
</html>