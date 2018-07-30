package com.neu.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class LoginController extends AbstractController {      

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        String action = request.getParameter("action");
       
        if(action==null) {  
            return new ModelAndView("login");
        }
        else if (action.equals("login")) {            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String value = request.getParameter("rememberMe");
            
                if(value!=null){
                    if (value.equals("remember") ) {
                        Cookie c1 = new Cookie ("username",username);
                        Cookie c2 = new Cookie ("password", password);

                        response.addCookie(c1);
                        response.addCookie(c2);                  
                    }
                }                
                
                if (username.equals("admin") && password.equals("admin")) {
                    //username/password correct, go to search page
                    //add username to the session
                    session.setAttribute("username", username);
                    return new ModelAndView("searchCourse");
                } 
                else {
                    return new ModelAndView("login");
                    //username/password not correct, send user to error-page or login page
                }   
        }            
        else if (action.equals("logout")) {
                    //invalidate() removes all the objects from the session
                    session.invalidate();
                    return new ModelAndView("login");
        }
        return new ModelAndView("login");
    }
}