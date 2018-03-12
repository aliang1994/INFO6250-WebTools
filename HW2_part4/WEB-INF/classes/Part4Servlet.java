//package part2;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Part4Servlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String firstline ="[Part 4] Print out all of the user inputs in the form:";


		Map<String, String[]> m = req.getParameterMap();


		out.println("<html>");
        out.println("<head>");
        out.println("<title> page1 </title>");
        out.println("</head>");
        out.println("<body bgcolor='pink'>");
        out.println("<h1>" + firstline + "</h1>");

        for (String key: m.keySet()){
        	String values[] = m.get(key);
            out.println("[name:]" + key +  "<br/>");
            for(String s: values){
                out.println("[value:]" + s );
            }  
            out.println("<br/><br/>");  	
        }

   

        out.println("</body>");
        out.println("</html>");
    }
}