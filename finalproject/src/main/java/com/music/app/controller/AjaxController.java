package com.music.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.music.app.dao.DAOFactory;
import com.music.app.dao.UserDAO;
import com.music.app.pojo.User;

@Controller
public class AjaxController {
	
	@Autowired
	private DAOFactory factory;	
	
	public AjaxController(){
		
	}
	
	@RequestMapping (value = "/ajaxservice.htm", method = RequestMethod.POST)
	@ResponseBody
	public String ajaxService(HttpServletRequest request){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		UserDAO userdao = factory.createUserDAO();
		User u = userdao.get(username, password);
		
		
		String result = "";
		if(u==null){
			result = result + "invalid username and password!!";
		}
		
		return result;
	} 
}