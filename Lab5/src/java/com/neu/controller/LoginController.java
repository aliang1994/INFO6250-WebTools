/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.LoginDAO;
import com.neu.pojo.Login;
import com.neu.validator.LoginValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Wenqing
 */
public class LoginController extends SimpleFormController {
    
    public LoginController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Login.class);
        setCommandName("login");
        setSuccessView("loginsuccess");
        setFormView("loginform");
        setValidator(new LoginValidator());
    }
    
//    @Override
//    protected void doSubmitAction(Object command) throws Exception {
//    }

//    Use onSubmit instead of doSubmitAction 
//    when you need access to the Request, Response, or BindException objects
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        
        ModelAndView mv = null;
        
        Login loginUser =(Login) command;
        
        LoginDAO  ldao= (LoginDAO) this.getApplicationContext().getBean("ldao");
        
        HttpSession session = request.getSession();
        
        if(ldao.checkLogin(loginUser)){
            session.setAttribute("username",loginUser.getUsername());
            mv = new ModelAndView(getSuccessView());
        }
        else{
            mv = new ModelAndView("error","message","Incorrect Username and Password");
        }        
        return mv;
    }     
}