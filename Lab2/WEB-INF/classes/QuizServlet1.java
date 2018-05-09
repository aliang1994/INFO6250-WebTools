import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuizServlet1 extends HttpServlet {
    //Service method

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        PrintWriter out = response.getWriter();
        
        //question 1
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Quiz</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Page 1</h2>");
        out.println("<form action = 'quizservlet1' method = 'post'>");
        out.println("<p>Question 1: Which method doesn't exist in HttpServlet class?</p>"
                + "<input type='radio' name='ans' value='post' />Post<br />"
                + "<input type='radio' name='ans' value='init' />Init<br />"
                + "<input type='radio' name='ans' value='get' />Get<br />"
                + "<input type='radio' name='ans' value='option' />Option<br />");

        out.println("<input type = 'hidden', name = 'page', value = 'p1'> ");  // passing page number in hidden values

        out.println("<input type =  'submit' value = 'Next' name = 'button'/><br />");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        //Create a session
        HttpSession session1 = request.getSession();

        //question 2; page 2; extracting page numbers
        String page =  request.getParameter("page");

        if(page.equals("p1")){

            String answer1 = request.getParameter("ans");
            session1.setAttribute("ans1", answer1);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Quiz</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Page 2</h2>");
            out.println("<form action = 'quizservlet1' method = 'post'>");
            out.println("<p>Question 2 : Which method is called when client request came?</p>"
                    + "<input type='radio' name='ans' value='post' />Post<br />"
                    + "<input type='radio' name='ans' value='init' />Init<br />"
                    + "<input type='radio' name='ans' value='get' />Get<br />"
                    + "<input type='radio' name='ans' value='option' />Option<br />");

            out.println("<input type = 'hidden', name = 'page', value = 'p2'> ");

            out.println("<input type =  'submit' name = 'button' value = 'Next' /><br />");
            out.println("<input type =  'submit' name = 'button' value = 'Back' /><br />");

            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

        else if(page.equals("p2")){
            String but2 = request.getParameter("button");
            if(but2.equals("Back")){
                String answer1 = request.getParameter("ans");
                session1.setAttribute("ans1", answer1);

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Quiz</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Page 1</h2>");
                out.println("<form action = 'quizservlet1' method = 'post'>");
                out.println("<p>Question 1: Which method doesn't exist in HttpServlet class?</p>"
                        + "<input type='radio' name='ans' value='post' />Post<br />"
                        + "<input type='radio' name='ans' value='init' />Init<br />"
                        + "<input type='radio' name='ans' value='get' />Get<br />"
                        + "<input type='radio' name='ans' value='option' />Option<br />");

                out.println("<input type = 'hidden', name = 'page', value = 'p1'> ");  // passing page number in hidden values

                out.println("<input type =  'submit' value = 'Next' name = 'button'/><br />");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

            }
            else{
                String answer2 = request.getParameter("ans");
                session1.setAttribute("ans2",answer2);

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Quiz</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Page 3</h2>");
                out.println("<form action = 'quizservlet1' method = 'post'>");
                out.println("<p>Question 3: Which HTTP method is idempotent ?</p>"
                        + "<input type='radio' name='ans' value='post' />Post<br />"
                        + "<input type='radio' name='ans' value='init' />Init<br />"
                        + "<input type='radio' name='ans' value='get' />Get<br />"
                        + "<input type='radio' name='ans' value='option' />Option<br />");

                out.println("<input type = 'hidden', name = 'page', value = 'p3' >");

                out.println("<input type =  'submit' value = 'Next' name = 'button'/><br />");
                out.println("<input type =  'submit' value = 'Back' name = 'button'/><br />");

                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
        }

        else if(page.equals("p3")){
            String but3 = request.getParameter("button");
             if(but3.equals("Back")){
                String answer1 = request.getParameter("ans");
                session1.setAttribute("ans1", answer1);

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Quiz</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Page 2</h2>");
                out.println("<form action = 'quizservlet1' method = 'post'>");
                out.println("<p>Question 2 : Which method is called when client request came?</p>"
                        + "<input type='radio' name='ans' value='post' />Post<br />"
                        + "<input type='radio' name='ans' value='init' />Init<br />"
                        + "<input type='radio' name='ans' value='get' />Get<br />"
                        + "<input type='radio' name='ans' value='option' />Option<br />");

                out.println("<input type = 'hidden', name = 'page', value = 'p2'> ");

                out.println("<input type =  'submit' name = 'button' value = 'Next' /><br />");
                out.println("<input type =  'submit' name = 'button' value = 'Back' /><br />");

                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
             }
             else{
                String answer3 = request.getParameter("ans");
                session1.setAttribute("ans3",answer3);


                String a1 = (String)session1.getAttribute("ans1");
                String a2 = (String)session1.getAttribute("ans2");
                String a3 = (String)session1.getAttribute("ans3");


                out.println("<html>");
                out.println("<head>");
                out.println("<title>Quiz</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Results here:</h2>");


                out.println("<input type = 'hidden', name = 'page', value = 'p4' > <br />");
                //out.println("<input type =  'submit' value = 'Back' name = 'button'/><br />");

                out.println("<h3>answer1:"+ a1 +" </h3>");
                out.println("<h3>answer2:"+ a2 +" </h3>");
                out.println("<h3>answer3:"+ a3 +" </h3>");


                out.println("</body>");
                out.println("</html>");

             }            
        }
    }
}
