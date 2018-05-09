package com.music.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.music.app.dao.DAOFactory;
import com.music.app.dao.UserDAO;
import com.music.app.pojo.User;



@Controller
public class UserController {
	
	@Autowired
	private DAOFactory factory;	
	
	public UserController(){
		
	}
		
	@RequestMapping(value = "/user/login.htm", method = RequestMethod.GET)
	public String showLoginForm() {
		return "user-login";
	}
	
	@RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
	public String handleLoginForm(HttpServletRequest request,  ModelMap map) {		
		
		UserDAO userdao = factory.createUserDAO();
		
		HttpSession session = request.getSession(true);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username + " " + password);
		
		try {
			User u = userdao.get(username, password);

			if (u != null) {
				session.setAttribute("currentuser", u);
				return "user-dashboard";			
			} 
//			else {
//				map.addAttribute("errorMessage", "Invalid username/password!");
//				return "user-login";
//			}
		} 
		catch (Exception e) {
			System.out.println("Could not login user "  +  e.getMessage());
		}
		return "user-login";
	}
	
	@RequestMapping(value = "/user/logout.htm", method = RequestMethod.GET)
	public String logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
		return "user-login";
	}
	
	@RequestMapping(value = "/user/create.htm", method = RequestMethod.GET)
	public String getCreateUserForm(HttpServletRequest request){
		return "user-create";
	}
	
	@RequestMapping(value = "/user/create.htm", method = RequestMethod.POST)
	public String handelCreateUserForm(HttpServletRequest request){
		HttpSession session = request.getSession(true);

		String username = request.getParameter("newusername");
		String password = request.getParameter("newpassword");
		
		System.out.println(username + " " + password);
		
		UserDAO userdao = factory.createUserDAO();
		User newuser = userdao.add(username, password);
		
		if(newuser!=null){
			return "user-createsuccessful";
		}
		return "user-create";		
	}
	
	
	@RequestMapping(value = "/user/delete.htm", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request) {
		return "user-login";
	}
}


