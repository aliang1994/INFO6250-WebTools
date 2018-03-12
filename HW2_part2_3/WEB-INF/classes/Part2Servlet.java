//package part2;

import java.util.Enumeration;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Part2Servlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String firstline ="Print out all of the request headers using Servlet:";

		Enumeration<String> allheaders = req.getHeaderNames();
                

		out.println("<html>");
        out.println("<head>");
        out.println("<title> page1 </title>");
        out.println("</head>");
        out.println("<body bgcolor='pink'>");
        out.println("<h1>" + firstline + "</h1>");

        while(allheaders.hasMoreElements()){
            String headername = allheaders.nextElement();
            out.println("header name:" + headername + "</br>");
            out.println("value:" + req.getHeader(headername) + "</br></br>");
        } 

        out.println("</body>");
        out.println("</html>");
    }
}