package com.music.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.music.app.dao.DAOFactory;
import com.music.app.dao.UserDAO;
import com.music.app.pojo.User;

@Controller
public class AdminController {
	
	@Autowired
	private DAOFactory factory;	
	
	public AdminController(){
		
	}
	
	//display admin error form
	@RequestMapping(value="/error.htm")
	public String showError(HttpServletRequest request){
		return "error";
	}
	
	//display admin login form
	@RequestMapping(value="/admin/login.htm", method = RequestMethod.GET)
	public String showLogin(HttpServletRequest request){
		return "admin-login";
	}
	
	//display admin central dashboard
	@RequestMapping(value="/admin/central.htm", method = RequestMethod.GET)
	public String showDashboard(HttpServletRequest request){
		return "admin-dashboard";
	}
	
	
	//display all user accounts
	@RequestMapping(value="/admin/user.htm", method = RequestMethod.GET)
	public String manageUserAccount(HttpServletRequest request){
		UserDAO udao = factory.createUserDAO();
		List<User> userlist = udao.displayAll();
		HttpSession session = request.getSession();
		session.setAttribute("userlist", userlist);
		return "admin-user-manageuser";
	}	
	
	//log out admin
	@RequestMapping(value="/admin/logout.htm")
	public String logoutAdmin(HttpServletRequest request){
		HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
		return "user-login";
	}
}
