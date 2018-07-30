package com.me.lab10Student.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.lab10Student.DAO.DAOFactory;
import com.me.lab10Student.DAO.MessageDAO;
import com.me.lab10Student.DAO.UserDAO;
import com.me.lab10Student.pojo.Message;
import com.me.lab10Student.pojo.User;

@Controller
public class UserController {

//	@Autowired
//	UserDAO userDAO;
//	
//	@Autowired
//	MessageDAO messageDAO;

	@Autowired
	DAOFactory daoFactory;
	
	@RequestMapping(value="/user/login.htm", method = RequestMethod.GET)
	public String showLoginForm(ModelMap model){
		User u = new User();
		model.addAttribute("user", u);
		return "user-form";
	}
	
	@RequestMapping(value="/user/login.htm", method = RequestMethod.POST)
	public String showSuccessPage(@ModelAttribute User command, ModelMap model, HttpServletRequest request){
		UserDAO userDAO = daoFactory.createUserDAO();
		MessageDAO messageDAO = daoFactory.createMessageDAO();
		
		User authenticatedUser = userDAO.authenticateUser(command);
		if(authenticatedUser != null){
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("userid", authenticatedUser.getUserId());
			httpSession.setAttribute("username", authenticatedUser.getUsername());
			List<Message> messages = messageDAO.getMessage(authenticatedUser.getUserId());
			model.addAttribute("messages", messages);
			return "user-success";
		}else{
			model.addAttribute("errorMessage","Username/Password is incorrect");
			return "error-page";
		}
	}

}
