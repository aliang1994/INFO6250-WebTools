/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.dao.UserDAO;
import com.pojo.User;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */
public class UserController extends AbstractController {
    
    public UserController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        UserDAO userdao = this.getApplicationContext().getBean("userdao", UserDAO.class);
        
        User user;
        
        String url = request.getRequestURI();        
        System.out.println("the url is: " +  url);
       if (url.equalsIgnoreCase("/Lab7/user.htm")) {
            user = new User();
            user.setFirstname("Yusuf");
            user.setLastname("Ozbek");

            HashSet<String> courses = new HashSet<String>();

            courses.add("Course 1: INFO 5100");
            courses.add("Course 2: INFO 6250");
            courses.add("Course 3: INFO 7390");

            user.setCourses(courses);
            //persist the object into the database
            
            userdao.saveUser(user);
            return new ModelAndView("userview", "user", user);
        }           
        else if (url.contains("/Lab7/user-")) {
            String id  = url.substring((url.lastIndexOf("-") + 1), url.lastIndexOf("."));
            // user-123.htm 
            user = userdao.getUser(Integer.parseInt(id));
            //Below code will give exception if user is not present. JSP Expression language handles Null Pointer Exception
            //System.out.println(user.getfName());
            return new ModelAndView("userview", "user", user);
        }
        return new ModelAndView("index");
    }    
}