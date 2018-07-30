package com.me.lab10Student.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import com.me.lab10Student.pojo.Message;

public class MessageDAO extends DAO{
   public List<Message> getMessage(int user_id){
	   String hqlQuery = "from Message where receiver = :userid";
	   Query q = getSession().createQuery(hqlQuery);
	   q.setParameter("userid", user_id);
	   List<Message> messages = q.list();
	   close();
	return messages;
	   
   }
   
   public boolean deleteMessage(int msg_id){
	   Message msg = new Message();
	   msg.setMessageId(msg_id);
	   try{
		   begin();
		   getSession().delete(msg);
		   commit();
		   return true;
	   }catch(HibernateException e){
		   rollback();
		   e.printStackTrace();
	   }finally{
		   close();	   
	   }
	   return false;
   }
}
