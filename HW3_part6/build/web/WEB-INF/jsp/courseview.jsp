<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page import="com.neu.bean.Course"/>
<jsp:directive.page import="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Available Courses are:</title>
    </head>
    <body>        
        <form action='course.htm'method = "post">
            <h2> Results found </h2>
            <c:forEach items = "${requestScope.searchResult}" var="result">                
                <input type='checkbox' name='crn' value="${result.crn}" />                 
                ${result.crn}
                ${result.name}
                ${result.courseDescription}
                ${result.instructor}
                [<a href ='course.htm?action=add&crn=${result.crn}'> Add Course</a>]<br/>   
            </c:forEach>
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>