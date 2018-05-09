package com.yusuf.spring.controller;

import com.yusuf.spring.dao.CategoryDAO;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.yusuf.spring.pojo.Category;
import com.yusuf.spring.dao.DAO;


public class AddCategoryFormController extends SimpleFormController
{
    public AddCategoryFormController(){
        //controller properties here initialized in dispatcher-servlet.xml
        
        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception{
        Category cat = (Category) command;
        try{
            CategoryDAO category = new CategoryDAO();
            category.create(cat);
            DAO.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }        
    }
}