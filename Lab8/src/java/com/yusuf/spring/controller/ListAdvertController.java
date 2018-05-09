/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yusuf.spring.controller;

import com.yusuf.spring.dao.CategoryDAO;
import com.yusuf.spring.dao.DAO;
import com.yusuf.spring.pojo.Advert;
import com.yusuf.spring.pojo.Category;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */
public class ListAdvertController extends AbstractController {
    
    public ListAdvertController() {
    }
    
    protected ModelAndView handleRequestInternal( HttpServletRequest request, HttpServletResponse response) throws Exception {
        CategoryDAO categories = null;
        List categoryList = null;
        List advList= new ArrayList();
        
        try{
            categories = new CategoryDAO();
            categoryList = categories.list();
            Iterator categIterator = categoryList.iterator();
            while(categIterator.hasNext()){
                Category category = (Category) categIterator.next();
                Iterator advIterator = category.getAdverts().iterator();
                while(advIterator.hasNext()){
                    Advert advert = (Advert)advIterator.next();
                    advList.add(advert);
                }
            }
            DAO.close();
        }
        catch(Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
        return null;
    }    
}