/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yusuf.spring.dao;

import com.yusuf.spring.exception.AdvertException;
import com.yusuf.spring.pojo.Advert;
import com.yusuf.spring.pojo.User;
import org.hibernate.HibernateException;

/**
 *
 * @author Wenqing
 */
public class AdvertDAO extends DAO {
    public Advert create(String title, String message, User user) throws AdvertException{
        try{
            begin();
            Advert advert  = new Advert(title, message, user);
            getSession().save(advert);
            commit();
            return advert;
        }
        catch(HibernateException e){
            rollback();
            throw new AdvertException("Exception while creating advert: "+ e.getMessage());
        }
    }
}
