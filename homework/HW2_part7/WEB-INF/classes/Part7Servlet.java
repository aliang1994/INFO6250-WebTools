import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import javax.servlet.RequestDispatcher;

public class Part7Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        String action = request.getParameter("action");

        Map<String, String> myCart;
        if(session.getAttribute("ShoppingCart") != null){
            myCart = (Map<String,String>) session.getAttribute("ShoppingCart");
        }
        else{
            myCart = new HashMap<String,String>();
        }

        String m1 = "Music No.1 [$1.99]";
        String m2 = "Music No.2 [$2.90]";
        String m3 = "Music No.3 [$0.99]";
        String b1 = "Book No.1 [$19.90]";
        String b2 = "Book No.2 [$29.90]";
        String b3 = "Book No.3 [$9.99]";
        String c1 = "Computer No.1 [$1990]";
        String c2 = "Computer No.2 [$2990]";
        String c3 = "Computer No.3 [$999]";

        //add items to cart
        if(action.equals("add")){
        	String[] product = request.getParameterValues("product");  
	        for(String pname: product){	        	
	        	if(pname.equals("music1")){
	        		myCart.put("music1", m1);
	        	}
	        	if(pname.equals("music2")){
	        		myCart.put("music2", m2);
	        	}
	        	if(pname.equals("music3")){
	        		myCart.put("music3", m3);
	        	}
	        	if(pname.equals("book1")){
	        		myCart.put("book1", b1);
	        	}
	        	if(pname.equals("book2")){
	        		myCart.put("book2", b2);
	        	}
	        	if(pname.equals("book3")){
	        		myCart.put("book3", b3);
	        	}
	        	if(pname.equals("computer1")){
	        		myCart.put("computer1", c1);
	        	}
	        	if(pname.equals("computer2")){
	        		myCart.put("computer2", c2);
	        	}
	        	if(pname.equals("computer3")){
	        		myCart.put("computer3", c3);
	        	}
	        }
        }
        else if(action.equals("delete")){
        	String[] product = request.getParameterValues("selectedproduct");
        	Iterator<String> it = myCart.keySet().iterator();
			  	while (it.hasNext()) {
			  		String nextitem =it.next();
			   		for(String pr: product){
        				if(nextitem.contains(pr)){
							it.remove();        				
						}
        			}  
			   }
        }

        session.setAttribute("ShoppingCart", myCart);

        RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
        rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	doGet(request,response);
	}
}