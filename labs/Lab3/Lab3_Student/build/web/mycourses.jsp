<jsp:directive.page import="java.util.*"/>
<jsp:directive.page import="Bean.Course"/>
<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        [<a href='searchCourse.jsp'>Go to Search page</a>] 
        [<a href="login.do?action=logout">Logout</a>]
        <form action ="course.do" method = "post"> 
            <h3> Courses Added:</h3>
            <!--if there are no course in the set-->
            <jsp:scriptlet>
                <![CDATA[
                HashSet<Course> myCourseSet = (HashSet<Course>) session.getAttribute("myCourseSet");                
                if (myCourseSet == null) {
                    out.println("<div><p> No Course Added for you.</p></div>");
                } 
                else {
                    //else if there are courses, display every course in the set
                    for (Course course : myCourseSet) {
                        out.println("CRN: " + course.getCrn() + " - Course Name: " + course.getName() + 
                        "[<a href='course.do?action=remove&crn=" + course.getCrn() + "'>Remove Course</a>]<br />");
                    }
                }
                ]]>
            </jsp:scriptlet>
            <input type = "hidden" name = "action" value = "remove"/>
        </form>
    </body>
</html>
