<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page import="java.util.*"/>
<jsp:directive.page import="com.neu.bean.Course"/>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        [<a href="course.htm">Go to Search page</a>] 
        [<a href="login.htm?action=logout">Logout</a>]
        <form action ="course.htm" method = "post"> 
            <h3> Courses Added:</h3>
            <!--if there are no course in the set-->
            <c:if test ="${empty sessionScope.myCourseSet}">
                <c:out value="No Course Added for you."></c:out>
            </c:if>
            <!--if there are courses in the set-->
            <c:if test ="${not empty sessionScope.myCourseSet}">
                <c:forEach items = "${sessionScope.myCourseSet}" var="course">
                    ${course.crn} 
                    ${course.name}
                    ${course.courseDescription}
                    [<a href='course.htm?action=remove&crn=${course.crn}'>Remove Course</a>]<br />
                </c:forEach>
            </c:if>          
            <input type = "hidden" name = "action" value = "remove"/>
        </form>
    </body>
</html>
