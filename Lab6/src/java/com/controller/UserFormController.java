/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.pojo.User;
import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Wenqing
 */
public class UserFormController extends SimpleFormController {
    
    public UserFormController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        User user =(User) command;
       
        CommonsMultipartFile fileInMemory = user.getPhoto();
        user.setPhotofile(fileInMemory.getOriginalFilename());
        
        File testFile = new File("C://uploads//", fileInMemory.getOriginalFilename());
        fileInMemory.transferTo(testFile);
        
        //hibernate        
        Configuration cfg = new Configuration();
        SessionFactory sf = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(user);
        tx.commit();
        session.close();
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        return mv;
    }
     */
}