package com.me.lab10Student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.lab10Student.DAO.DAOFactory;
import com.me.lab10Student.DAO.MessageDAO;

@Controller
public class MessageController {
	
	@Autowired
	DAOFactory daoFactory;
	
	@RequestMapping(value = "/message/delete.htm" , method = RequestMethod.GET)
	public ModelAndView deleteMessage(HttpServletRequest request) {
		
		MessageDAO messageDAO = daoFactory.createMessageDAO();
		
		HttpSession httpSession = request.getSession(false);
		if (httpSession.getAttribute("username") == null) {
			return new ModelAndView("error-page","errorMessage", "You have to login to access this page");
		}
		
		int msgId =  Integer.parseInt(request.getParameter("msgid"));
		
		boolean deleteBool = messageDAO.deleteMessage(msgId);
		
		if (deleteBool) {
			return new ModelAndView("message-deleted");
		} else {
			return new ModelAndView("error-page", "errorMessage", "Error while deleting the selected message");
		}
		
	}
}