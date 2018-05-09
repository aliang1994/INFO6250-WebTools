/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yusuf.spring.dao;

import com.yusuf.spring.exception.UserException;
import com.yusuf.spring.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Wenqing
 */
public class UserDAO extends DAO {
    public UserDAO()   {
        
    }
    
    public User get(String username) throws UserException{
        try{
            begin();
            Query q = getSession().createQuery("from User where name = :username");
            q.setString("username", username);
            User user = (User)q.uniqueResult();
            commit();
            return user;
        }
        catch(HibernateException e){
            rollback();
            throw new UserException("Could not get user " + username, e);
        }
    }
    
    public User create(User user) throws UserException{
        try{
            begin();
            getSession().save(user);
            commit();
            return user;
        }
        catch(HibernateException e){
            rollback();
            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }
}