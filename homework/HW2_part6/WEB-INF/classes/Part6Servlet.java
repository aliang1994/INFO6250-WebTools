import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Part6Servlet extends HttpServlet {
    //Service method

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        PrintWriter out = response.getWriter();
        
        //question 1
        out.println("<html>");
        out.println("<head>");
        out.println("<title>hw2part6</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form action = 'part6' method = 'post'>");
        out.println("<p>How many chilren do you have?</p>");
        out.println("<input type='text' name='numchild'  /> <br />");
        out.println("<input type = 'hidden' name = 'page' value = 'p1'> ");  
        out.println("<input type = 'submit' name = 'button' value = 'Submit Query' ;' /><br />");        
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session1 = request.getSession();

        String page =  request.getParameter("page");
      

        if(page.equals("p1")){
            String numchild = request.getParameter("numchild");            
            try{
                int numentered = Integer.parseInt(numchild);
                session1.setAttribute("num", numentered);
                out.println("<html>");
                out.println("<head>");
                out.println("<title>hw2part6</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form action = 'part6' method = 'post'>");
                for (int m=1; m<=numentered; m++){
                    out.println("Please enter the name of  your child " + m + "<br />");
                    out.println("<input type = 'text', name = 'childname'> <br /> ");
                }
                out.println("<input type = 'submit' name = 'button' value = 'Submit Query' ;' /><br />");
                out.println("<input type = 'hidden', name = 'page', value = 'p2'> ");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
                
            }
            catch(NumberFormatException exception){
                out.println("Please enter valid numerical values!!");
            }            
        }

        else if(page.equals("p2")){                
                int numentered = (Integer)session1.getAttribute("num");
                String str[] = request.getParameterValues("childname"); 

                out.println("<html>");
                out.println("<head>");
                out.println("<title>hw2part6</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<form action = 'part6' method = 'post'>");
                out.println("Your childrens' name are: <br />");
                for(String s: str){
                    out.println(s + " <br />");
                }
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");            
        }
    }
}