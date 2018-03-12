/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends AbstractController {
    private HashMap<String,String> productlist;
    public CartController(){
        productlist= new HashMap<String,String>();
        String m1 = "Music No.1 [$1.99]";
        String m2 = "Music No.2 [$2.90]";
        String m3 = "Music No.3 [$0.99]";
        String b1 = "Book No.1 [$19.90]";
        String b2 = "Book No.2 [$29.90]";
        String b3 = "Book No.3 [$9.99]";
        String c1 = "Computer No.1 [$1990]";
        String c2 = "Computer No.2 [$2990]";
        String c3 = "Computer No.3 [$999]";
        productlist.put("book1",b1);
        productlist.put("book2",b2);
        productlist.put("book3",b3);
        productlist.put("music1",m1);;
        productlist.put("music2",m2);
        productlist.put("music3",m3);
        productlist.put("computer1",c1);
        productlist.put("computer2",c2);
        productlist.put("computer3",c3);
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        // return - view; model name; model object
        //return new ModelAndView("userview","userlist", users);
        
        HttpSession session = request.getSession(false);
        String action = request.getParameter("action");
        ArrayList<String> myCart;
        if(session.getAttribute("mycart") != null){
            myCart = (ArrayList<String>) session.getAttribute("mycart");
        }
        else{
            myCart = new ArrayList<String>();
        }
        
        if(action.equals("viewbooks")){
            return new ModelAndView("books");
        }
        if(action.equals("viewmusic")){
            return new ModelAndView("music");
        }
        if(action.equals("viewcomputer")){
            return new ModelAndView("computer");
        }
        if(action.equals("viewcart")){
            return new ModelAndView("cart");
        }
        
        if(action.equals("add")){
        	String[] product = request.getParameterValues("product");  
                for (String s: product){
                    for(String prod: productlist.keySet()){
                        if(s.equals(prod)){
                            myCart.add(s);                        
                        }
                    }
                }
                session.setAttribute("mycart", myCart);
                return new ModelAndView("cart","mycart",myCart);
        }
        if(action.equals("delete")){
        	String[] product = request.getParameterValues("selectedproduct");
                for (String s: product){
                    for(String prod: productlist.keySet()){
                        if(s.equals(prod)){
                            myCart.remove(s);                        
                        }
                    }
                }
                session.setAttribute("mycart", myCart);
                return new ModelAndView("cart","mycart",myCart);        	
        }
        return new ModelAndView("index");
    }
}    