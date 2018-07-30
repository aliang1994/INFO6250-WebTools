 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Wenqing
 */
public class UserDAO extends DAO {
    //Every subclass of DAO will have the operations that will be performed on the POJO(save, get, delete, update)
    
    Session session;
    
    public UserDAO() {  
        
    }
    
    public User saveUser (User user) {        
        session = super.sf.openSession();
        Transaction tx = session.beginTransaction();
        //Hibernate doesnot auto commit transactions. So we need to explicitly commit. 
        //Otherwise the object will not be saved (Will be rolled back)
        session.save(user);
        tx.commit();
        session.close();
        return user;
    } 
    
    public User getUser (int id) {
        session = super.sf.openSession();
        //Transaction is not needed because it is not a DManupulationL operation.
        User user = (User) session.get(User.class, id);
        return user;
    }
    
    public User updateUser (User user) {
        session = super.sf.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
        return user;
    }
    
    public User deleteUser (User user) {
        session = super.sf.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        session.close();
        return user;      
    }
}