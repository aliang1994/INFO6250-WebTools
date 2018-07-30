package com.yusuf.spring.controller;

import org.springframework.web.servlet.mvc.SimpleFormController;

import com.yusuf.spring.pojo.User;
import com.yusuf.spring.dao.DAO;
import com.yusuf.spring.dao.UserDAO;
import com.yusuf.spring.exception.AdvertException;
import com.yusuf.spring.exception.UserException;

public class AddUserFormController extends SimpleFormController {

    public AddUserFormController()    {
        //parameters defined in dispatcher-servlet.xml
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception    {
        User newUser = (User)command;
        try{
            UserDAO userDao = new UserDAO();
            userDao.create(newUser);
            DAO.close();
        }
        catch(UserException e){
            System.out.println("Exception: " + e.getMessage());
        }        
    }
}