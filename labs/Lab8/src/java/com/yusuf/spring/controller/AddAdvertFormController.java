package com.yusuf.spring.controller;

import com.yusuf.spring.dao.AdvertDAO;
import com.yusuf.spring.dao.CategoryDAO;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.yusuf.spring.dao.DAO;
import com.yusuf.spring.dao.UserDAO;
 

import com.yusuf.spring.pojo.Advert;
import com.yusuf.spring.pojo.Category;
import com.yusuf.spring.pojo.User;

import com.yusuf.spring.exception.AdvertException;

public class AddAdvertFormController extends SimpleFormController {

    public AddAdvertFormController() {
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        Advert adv = (Advert) command;
        
        String username = adv.getPostedBy();
        String categoryTitle = adv.getCategory();
        String title = adv.getTitle();
        String message = adv.getMessage();
        
        try{
            UserDAO users = new UserDAO();
            CategoryDAO categories = new CategoryDAO();
            AdvertDAO adverts = new AdvertDAO();
            
            User user = users.get(username);
            Category category = categories.get(categoryTitle);
            Advert advert = adverts.create(title, message, user);
            
            category.addAdvert(advert);
            categories.save(category);
            
            DAO.close();
                 
        }
        catch(AdvertException e){
            System.out.println("exception" + e.getMessage());
        }
    }
}