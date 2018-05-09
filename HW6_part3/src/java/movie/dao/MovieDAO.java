/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.dao;

import java.util.ArrayList;
import java.util.List;
import movie.pojo.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Wenqing
 */
public class MovieDAO {
    Configuration conf = new Configuration();
    SessionFactory sf = conf.configure("hibernate.cfg.xml").buildSessionFactory();
    
    public Movie addMovie(Movie m){
        try{
            Session ses = sf.openSession();
            Transaction tx = ses.beginTransaction();
            ses.save(m);
            tx.commit();
            ses.close();
            return m;
        }
        catch(HibernateException e){
            System.out.println("Error when adding movie:" + e.getMessage());
        }
        return m;        
    }
    
    public List<Movie> searchMovie(String criteria, String input){                
        try{            
            Session ses = sf.openSession();
            Transaction tx = ses.beginTransaction();
            SQLQuery q = ses.createSQLQuery("SELECT * FROM MOVIES WHERE " + criteria + "= '" + input + "'");
            q.addEntity(Movie.class);
            List<Movie> result =  q.list();
            tx.commit();
            ses.close();   
            return result;
        }
        catch(HibernateException e){
            System.out.println("Error when search movie:" + e.getMessage());
        }      
        return null;
    }
}