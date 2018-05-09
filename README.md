# INFO6250-WebTools
# Programming Assignments

Homework 2
  Part 2.  
    Write a servlet that displays request headers using:
    Enumeration getHeaderNames()
    Enumeration getHeaders(String name)
  Part 3.  
    Repeat Part 2 using a JSP page.
  Part 4.  
    Create a servlet to read and display user input from the form you created in HW1 using getParameterMap() method.
  PART 5.  
    Redo Part 4 by using getParameterNames() method.
  PART 6.  
    Use only 1 servlet to implement the application: "How many children do you have". Initially form is displayed in the doGet method,
    and initially form submission will be handled in JavaScript that creates the page as shown in the second screenshot.
    Now, this form (2nd screenshot) is to be submitted via POST so that the same servlet could handle this request in the same servlet.
  PART 7.  
    You will be using a session object to store and retrieve selected items from a simple shopping cart application. 
    Shopping cart applications typically allow users to select items from a catalog and place them in a virtual shopping cart. When the 
    user selects some items and     presses the Add to Cart" button, the servlet will add the selected items to the session object and 
    then retrieve all of the items currently in the session object and then display them in the browser. Removing an item from the shopping cart will be from the same servlet. Use
    URL-rewriting or hidden fields as necessary. There are 3 different types of products: music, book, computer
    
    
Homework 3
  Part 4.  
    Create a JSP page that uses at least 3 JSTL tags from each tag library group, i.e.,3 tags from Core Tag Lib, 3 tags from Formatting 
    Tag Lib, etc. You could use random content on the JSP page.
  Part 5.  
    Redo Lab 3 project, but replace the scriptlet tags with JSTL and EL.
  Part 6.  
    Convert Lab 3 to a Spring MVC Application.
  Part 7.  
    Convert H2Part7 to a Spring MVC Application.
    
    
Homework 4
  Part 2. 
    Create an MVC application to browse movies and add new movies to the DB. You could use AbstractControllers, but the AddMoviePage 
    should be SimpleFormController. 
  Part 3. 
    Prepared Statement and Spring MVC. Use PreparedStatement to enter the books to the database whose details shown below. 
    Implement using Spring MVC. (You may change/improve the views.)
  PART 6.  
    (Use ONLY 1 CONTROLLER and 1 JSP page)
    Read the attached CSV file using CsvJdbc Driver - http://csvjdbc.sourceforge.net
    JSP page initially displays a FORM having a textbox for the user to enter the name of the CSV file. This form will be submitted 
    to a Spring MVC controller that will read the name of the file, and connect to the CSV file using CsvJdbc.
    Once the connection is established, the Controller will get the data from the CSV file , and place into a Model, and then call
    the same JSP page again. This Model to be displayed on the same JSP page using JSTL and EL a Tabular format (Textboxes in HTML table).
    This form to be submitted to the same Spring MVC Controller which will use a PreparedStament and Batch queries to insert into a 
    MySQL database. Once this is successfull, number of rows inserted to be passed to the same JSP page to be displayed.
  PART 7. 
    Redo Part-6 of this assignment by utilizing a CustomTag in the JSP page to display the data retrieved from CSV. The name of the CSV 
    file is to be passed to CustomTagHandler class either as an attribute or body content (you decide which one to use). In the doTag 
    method, you simply read the name of the CSV file using CsvJdbc, and retrieve all the data and display on the JSP page. You may create 
    the tabular format in the doTag method. Once the table is displayed on the JSP page, use PreparedStament and Batch queries to insert 
    into a MySQL database as you did in Part 6.
    
    
Homework 5 
  PART 3 
    Modify HW4Part2 by adding Declarative Web Application Security. 
    Replace JDBC with Hibernate (XML Mapping).
    Annotate all the Spring Controllers.
    Add a FILTER to validate and sanitize Script and SQL Injection using Regular Expressions.
  PART 4 
    Modify HW4Part3 by adding Programmatic Web Application Security.
    Replace JDBC with Hibernate (Annotated POJOs).
    Annotate all the Spring Controllers.
    Add a FILTER to validate and sanitize Script and SQL Injection using Regular Expressions.
    

Homework 6
  PART 1 
    Modify HW4Part6 using Pagination technique to display 100 records per page as discussed in the lecture.
    On the bottom of the page there will be page numbers.
    Clicking on each page number will get 100 rows from the CSV file using CsvJdbc Driver.
  PART 2 
    Redo PART 1 but place a SUBMIT BUTTON on the bottom of the page “SAVE TO EXCEL”.
    Now, we create an Excel View (using AbstractXlsView), and place all the values into the Excel Sheet.
  PART 3 
    Redo HW4Part2
    using Hibernate (Annotated Controllers and Annotated POJOs)


Lab 2 - Quiz Servlet
Lab 3 - Course Adding/Deleting
Lab 4 - Sending Message
Lab 5
Lab 6 - Common File Upload
Lab 7
Lab 8 - Advert-Category Application uxing XML mapping
Lab 9 - Advert-Category Application using Annotations
Lab 10
Lab 11 - Ajax
