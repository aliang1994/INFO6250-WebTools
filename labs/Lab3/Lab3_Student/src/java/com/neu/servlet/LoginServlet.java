package com.neu.servlet;

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

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
       
        if(action.equals("login")) {            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String value = request.getParameter("rememberMe");
            
            //session user existed : redirect to searchCourse.jsp            
            if(session.getAttribute("username")!=null){
                if(session.getAttribute("username").equals(username)){                    
                    response.sendRedirect("searchCourse.jsp");
                    return;
                }
            }
            
            //cookie existed: redirect to searchCourse
            Cookie[] cookies = request.getCookies();  
            if(cookies != null){  
                for (Cookie c: cookies){
                    if(c.getValue().equals("admin")){
                        response.sendRedirect("searchCourse.jsp");
                        return;
                    }                        
                }
            }     
            //user does not check the box for logging in
            if(value == null){
                if (username.equals("admin") && password.equals("admin")) {
                    //username/password correct, go to search page
                    //add username to the session
                    session.setAttribute("username", username);
                    response.sendRedirect("searchCourse.jsp");
                } 
                else {
                        response.sendRedirect("index.jsp");
                        //username/password not correct, send user to error-page or login page
                }  
            }
            else if (value.equals("remember") ) {
                Cookie c1 = new Cookie ("username",username);
                Cookie c2 = new Cookie ("password", password);

                response.addCookie(c1);
                response.addCookie(c2);       
                if (username.equals("admin") && password.equals("admin")) {
                    //username/password correct, go to search page
                    //add username to the session
                    session.setAttribute("username", username);
                    response.sendRedirect("searchCourse.jsp");
                } 
                else {
                        response.sendRedirect("index.jsp");
                        //username/password not correct, send user to error-page or login page
                }
            }                   
        }            
        else if (action.equals("logout")) {
                    //invalidate() removes all the objects from the session
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                }
        }
        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}