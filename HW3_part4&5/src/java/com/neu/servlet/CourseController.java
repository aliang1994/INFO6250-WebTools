package com.neu.servlet;

import Bean.Course;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CourseController extends HttpServlet {

    List<Course> courseList;
    //Global object belongs to every users.
    //Be careful, do not put anything here that you don't want to share.
    //Later this will come from the database.

    @Override
    public void init() {
        //This method will only be call for once
        courseList = new ArrayList<>();
        Course c1 = new Course();
        c1.setCourseDescription("java programming");
        c1.setCrn("36099");
        c1.setInstructor("Khaled M. Bugrara");
        c1.setName("AED");

        Course c2 = new Course();
        c2.setCourseDescription("Course fro learning web technologies used in frint end");
        c2.setCrn("37913");
        c2.setInstructor("YusufOzbek");
        c2.setName("Web Dsign and user exp");

        Course c3 = new Course();
        c3.setCourseDescription("course for learning algorithms");
        c3.setCrn("34267");
        c3.setInstructor("Khaled M. Bugrara");
        c3.setName("Program Structure and Algorithms");

        Course c4 = new Course();
        c4.setCourseDescription("course for learning java EE");
        c4.setCrn("31606");
        c4.setInstructor("YusufOzbek");
        c4.setName("Web Tools");

        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //We are using one servlet for multiple things.
        //action is the url parameter to differentiate between different requests
        String action = request.getParameter("action");

        //this session will only be created when the user logs in. Otherwise do not create it.
        HttpSession session = request.getSession(false);
        
        Set<Course> myCourses;
        if(session.getAttribute("myCourseSet") != null){
            myCourses = (Set<Course>) session.getAttribute("myCourseSet");
        }
        else{
            myCourses = new HashSet<Course>();
        }

        if (action.equals("add")) {
            ////**************************
            String[] crn = request.getParameterValues("crn");  
            for(String cc: crn){
                for (Course c: courseList){
                    if(c.getCrn().equals(cc)){
                        myCourses.add(c);
                    }
                }
            }
            session.setAttribute("myCourseSet", myCourses);

            RequestDispatcher rd = request.getRequestDispatcher("/mycourses.jsp");
            rd.forward(request, response);
        } else if (action.equals("search")) {
            /////**********************
            String searchType = request.getParameter("searchType");
            String searchQuery = request.getParameter("query");
            
            ArrayList<Course> searchResult = new ArrayList<>();
            if(searchType.equals("crn")){
                for(Course c: courseList){
                    if(c.getCrn().equals(searchQuery)){
                        searchResult.add(c);
                    }
                }
            }
            else if(searchType.equals("title")){
                for(Course c: courseList){
                    if(c.getCourseDescription().contains(searchQuery)){
                        searchResult.add(c);
                    }
                }
            }
            request.setAttribute("searchResult", searchResult);
            
            RequestDispatcher rd = request.getRequestDispatcher("/courseview.jsp");
            rd.forward(request, response);
        } else if(action.equals("remove")) {
           //using cookie to store the course added
            
            String[] crn = request.getParameterValues("crn");  
            for(String cc: crn){
                for (Course c: courseList){
                    if(c.getCrn().equals(cc)){
                        myCourses.remove(c);
                    }
                }
            }
            session.setAttribute("myCourseSet", myCourses);
            
            RequestDispatcher rd = request.getRequestDispatcher("/mycourses.jsp");
            rd.forward(request, response);
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
