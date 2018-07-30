<%-- 
    Document   : HW3_part4
    Created on : Feb 12, 2018, 10:47:05 PM
    Author     : Wenqing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:directive.page import="java.util.*"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homework 3</title>
    </head>
    <body>
        <h1>Homework 3 - Part 4</h1>
        <p> Create a JSP page that uses at least 3 JSTL tags from each tag library group, i.e.,3 tags from Core Tag Lib, 3 tags from Formatting Tag Lib, etc. You
could use random content on the JSP page.</p> <br/>  <br/>  
        <c:out value = "Printing out some c tags on the page">  </c:out> <br/>        
        <c:forEach var="k" begin="1" end="10">
            value = ${k*k} <br/>
        </c:forEach>            
        <fmt:parseNumber type = "number" value = "${k}" />    <br/><br/> 
        
        <c:set var = "money" value = "1234.5678" />
        <fmt:formatNumber type = "number"   maxIntegerDigits = "3" value = "${money}" /><br/><br/> 
        
        <c:set var = "datetoday" value = "<%= new java.util.Date()%>" />
        <fmt:formatDate type = "time"  value = "${datetoday}" /><br/><br/> 
        
        <c:set var = "randomxml">
            <books>
               <book>
                  <name>book1</name>
                  <price>10</price>
               </book>
               <book>
                  <name>book2</name>
                  <price>20</price>
               </book>
            </books>
        </c:set>

        <x:parse xml = "${randomxml}" var = "output"/>
        <x:set var = "book" select = "$output//book"/>
        <x:out select = "$output/books/book[1]/name" />  <br/><br/> 
        
        
        <c:set var = "randomstring" value = "this is a random string"/>
        <c:set var = "randomstring2" value = "this is another random string"/>
        <c:if test = "${fn:contains(randomstring, 'this')}">
             <p>String contains the word "this"<p>
        </c:if>
        
        <p>Length of the random string (1) : ${fn:length(randomstring)}</p> 
        <p>Uppercase string :${fn:toUpperCase(randomstring2)}</p>        
    </body>
</html>