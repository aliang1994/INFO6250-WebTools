//package homework2;

import java.util.Enumeration;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Part5Servlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String firstline ="[Part 5] Print out all of the user inputs in the form:";


		Enumeration<String> allparams = req.getParameterNames();


		out.println("<html>");
        out.println("<head>");
        out.println("<title> page1 </title>");
        out.println("</head>");
        out.println("<body bgcolor='pink'>");
        out.println("<h1>" + firstline + "</h1>");

        while(allparams.hasMoreElements()){
            String name = allparams.nextElement();
            out.println("[name]: " + name);
            out.println("</br>");
            String[] value = req.getParameterValues(name);            
            for (String s: value){
                out.println("[value]: " + s);
            }      
             out.println("</br></br>");      
        } 

        out.println("</body>");
        out.println("</html>");
    }
}