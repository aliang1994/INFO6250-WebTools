package com.me.lab10Student.DAO;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import com.me.lab10Student.pojo.User;

public class UserDAO extends DAO{
	public User authenticateUser(User user){
		Criteria c = getSession().createCriteria(User.class);
		c.add(Example.create(user));
		User u = (User)c.uniqueResult();
		return u;		
	}

}
