package com.me.lab10Student.DAO;

public class DAOFactory {
        public UserDAO createUserDAO(){
        	return new UserDAO();
        }
        public MessageDAO createMessageDAO(){
        	return new MessageDAO();
        }    
}
