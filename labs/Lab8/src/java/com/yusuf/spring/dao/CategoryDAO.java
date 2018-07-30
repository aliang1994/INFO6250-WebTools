/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yusuf.spring.dao;

import com.yusuf.spring.exception.CategoryException;
import com.yusuf.spring.pojo.Category;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Wenqing
 */
public class CategoryDAO extends DAO { 
    public CategoryDAO(){

    }
    public Category get(String title) throws CategoryException{
        try{
            begin();
            Query q = getSession().createQuery("from Category where title= :title");
            q.setString("title", title);
            Category category = (Category) q.uniqueResult();
            commit();
            return category;
        }
        catch(HibernateException e){
            rollback();
            throw new CategoryException(("could not obtain the named category") + title + " " + e.getMessage());
        }
    }
    public Category create(Category cat) throws CategoryException{
        try{
            begin();
            //Category cat = new Category(title);
            getSession().save(cat);
            commit();
            return cat;
        }
        catch(HibernateException e)        {
            rollback();
            throw new CategoryException("Exception while creating category:" + e.getMessage());
        }
    }    
    
      public List list() throws CategoryException{
        try{
            begin();
            Query q = getSession().createQuery("from Category");
            List list = q.list();
            commit();
            return list;
        }
        catch (HibernateException e){
            rollback();
            throw new CategoryException("Could not list the categories", e);
        }                
    }
      
    public void save(Category category) throws CategoryException{
        try{
            begin();
            getSession().update(category);
            commit();
        }
        catch(HibernateException e){
            rollback();
            throw new CategoryException("Could not save the category", e);
        }
    }
}