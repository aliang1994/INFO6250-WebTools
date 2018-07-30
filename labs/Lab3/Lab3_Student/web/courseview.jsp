<jsp:directive.page import="Bean.Course"/>
<jsp:directive.page import="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Available Courses are:</title>
    </head>
    <body>        
        <form method='post' action='course.do'>
            <h2> Results found </h2>
            <jsp:scriptlet>     
                <![CDATA[
                ArrayList<Course>searchResult = (ArrayList<Course>)request.getAttribute("searchResult");
                for (Course c: searchResult){
                    String crn = c.getCrn();
                    String coursename = c.getName();
                    String desciption = c.getCourseDescription();
                    String instructor = c.getInstructor();
                    out.println("<input type='checkbox' name='crn' value='" + crn + "'/>" + crn + "-" + coursename + "[<a href ='course.do?action=add&crn=" + crn + "'> Add Course</a>]<br/>");                
                }
                ]]>
            </jsp:scriptlet>               
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>