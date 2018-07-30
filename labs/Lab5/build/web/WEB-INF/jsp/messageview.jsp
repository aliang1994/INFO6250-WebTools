<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
        [<a href="${contextPath}/message/dashboard.htm">DashBoard</a>]<br/><br/>
       
       
        <c:if test="${requestScope.map.msgtype eq 'search'}">Your Searched for ${requestScope.map.querySearched} </c:if>
        <c:if test="${(requestScope.map.msgtype eq 'display')||(requestScope.map.msgtype eq 'search')}">
            <table border="1">
                <tr>
                    <th>Message ID</th>
                    <th>From User</th>
                    <th>Message</th>
                    <th>Message Date</th>
                    <th>Delete Message</th>
                </tr> 
                <c:forEach items="${requestScope.map.msgList}" var="msg">
                    <tr>
                        <td>${msg.messageId}</td>
                        <td>${msg.fromUser}</td>
                        <td>${msg.message}</td>
                        <td>${msg.messageDate}</td>
                        <td><a href="${contextPath}/message/${msg.messageId}/delete.htm">Delete</a></td>
                    </tr> 
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${requestScope.msgtype eq 'send'}">
            <form action='${contextPath}/message/sendemail.htm' method="post">
                <p><b>From: </b><c:out value='${sessionScope.username}' /></p>
                <p><b>To: </b><input type="text" name="to" /></p>
                <p><b>Message: </b></p>
                <textarea name="message" rows="6" cols="40"></textarea><br/>
                <input type="submit" value="send" />
            </form>
        </c:if>
        
        <c:if test="${requestScope.map.msgtype eq 'delete'}">
            <c:if test="${requestScope.map.status eq 'deleted'}">
                <h3>Message has been deleted Successfully!</h3>
            </c:if>
            <c:if test="${requestScope.map.msgtype eq 'notdeleted'}">
                <h3>Message could not be deleted! Try Again</h3>
            </c:if>
        </c:if>
    </body>
</html>

