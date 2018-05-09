 package com.music.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.music.app.pojo.Playlist;
import com.music.app.pojo.User;



public class UserDAO extends DAO{
	public User get(String username, String password) {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :un and password = :pw");
			q.setString("un", username);
			q.setString("pw", password);			
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get user by username and password " +  e.getMessage());
			return null;
		}
	}
	
	public User getUserById(int id) {
		try {
			begin();
			Query q = getSession().createQuery("from User where userid =" + id);	
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get user by id " + id +  e.getMessage());
			return null;
		}
	}
	
	public User add(String username, String password)  {
		try {
			begin();
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setPlaylistAdded(new ArrayList<Playlist>());
			
			//check if username is already used
			Query q = getSession().createQuery("From User where username =:username");
			q.setString("username", username);
			List list =q.list();
			if(list.size()>0){
				System.out.println("User already existed");
				return null;
			}
			getSession().save(u);
			commit();
			return u;
		} catch (HibernateException e) {
			rollback(); 
			System.out.println("Could not add user  " +  e.getMessage());
			return null;
		}
	}

	public void delete(User user) {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not delete user " +  e.getMessage());
		}
	}
	
	public List<User> displayAll(){
		try {
			begin();
			Query q = getSession().createQuery("from User");
			List<User> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			System.out.println("Could not get all users" +  e.getMessage());
			return null;
		}
	}
}