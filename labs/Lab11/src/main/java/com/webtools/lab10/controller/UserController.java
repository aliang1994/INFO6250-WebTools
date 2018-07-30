package com.webtools.lab10.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.captcha.botdetect.web.servlet.Captcha;
import com.webtools.lab10.dao.UserDAO;
import com.webtools.lab10.pojo.User;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/user/login.htm", method = RequestMethod.GET)
	public String showLoginForm() {

		return "user-login";
	}
	@RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
	public String handleLoginForm(HttpServletRequest request, UserDAO userDao, ModelMap map) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			User u = userDao.get(username, password);

			if (u != null && u.getStatus() == 1) {
				return "user-dashboard";
			} else if (u != null && u.getStatus() == 0) {
				map.addAttribute("errorMessage", "Please activate your account to login!");
				return "error";
			} else {
				map.addAttribute("errorMessage", "Invalid username/password!");
				return "error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	
	@RequestMapping(value="/user/create.htm", method = RequestMethod.GET)
	public String showCreateForm(){
		return "user-create-form";
	}
	
	@RequestMapping(value="/user/create.htm", method = RequestMethod.POST)
	public String handleCreateForm(HttpServletRequest request, UserDAO userDao, ModelMap map){
		Captcha captcha = Captcha .load(request, "CaptchaObject");
		String captchaCode = request.getParameter("captchaCode");
		HttpSession session = request.getSession();
		if(captcha.validate(captchaCode)){
			String useremail = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User();
			user.setUserEmail(useremail);
			user.setPassword(password);
			user.setStatus(0);
		
			try{
				User u = userDao.register(user);
				Random rand = new Random();
				int randomNum1 = rand.nextInt(50000);
				int randomNum2 = rand.nextInt(50000);
				try{
					String str = "http://localhost:8080/lab10/user/validateemail.htm?email=" + useremail +"&key1="
							+ randomNum1 + "&key2=" + randomNum2;
					session.setAttribute("key1", randomNum1);
					session.setAttribute("key2", randomNum2);
					sendEmail(useremail,"click on this link to activate your account: " + str);
				}
				catch(Exception e){
					System.out.println("Email cannot be sent: " + e.getMessage());
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			map.addAttribute("errorMessage", "Invalid Captcha!");
			return "user-create-form";
		}
		return "user-created";		
	}
	
	@RequestMapping(value = "/user/forgotpassword.htm", method = RequestMethod.GET)
	public String getForgotPasswordForm(HttpServletRequest request) {
		
		return "forgot-password";
	}
	

	@RequestMapping(value = "/user/forgotpassword.htm", method = RequestMethod.POST)
	public String handleForgotPasswordForm(HttpServletRequest request, UserDAO userDao) {

		String useremail = request.getParameter("useremail");
		Captcha captcha = Captcha.load(request, "CaptchaObject");
		String captchaCode = request.getParameter("captchaCode");

		if (captcha.validate(captchaCode)) {
			User user = userDao.get(useremail);
			sendEmail(useremail, "Your password is : " + user.getPassword());
			return "forgot-password-success";
		} else {
			request.setAttribute("captchamsg", "Captcha not valid");
			return "forgot-password";
		}
	}
	
	@RequestMapping(value = "user/resendemail.htm", method = RequestMethod.POST)
	public String resendEmail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String useremail = request.getParameter("username");
		Random rand = new Random();
		int randomNum1 = rand.nextInt(5000000);
		int randomNum2 = rand.nextInt(5000000);
		try {
			String str = "http://localhost:8080/lab10/user/validateemail.htm?email=" + useremail + "&key1=" + randomNum1
					+ "&key2=" + randomNum2;
			session.setAttribute("key1", randomNum1);
			session.setAttribute("key2", randomNum2);
			sendEmail(useremail,
					"Click on this link to activate your account : "+ str);
		} catch (Exception e) {
			System.out.println("Email cannot be sent");
		}
		
		return "user-created";
	}
	
	public void sendEmail(String useremail, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("contactapplication2018@gmail.com", "springmvc"));
			email.setSSLOnConnect(true);
			email.setFrom("no-reply@msis.neu.edu"); // This user email does not
													// exist
			email.setSubject("Password Reminder");
			email.setMsg(message); // Retrieve email from the DAO and send this
			email.addTo(useremail);
			email.send();
		} catch (EmailException e) {
			System.out.println("Email cannot be sent");
		}
	}


	@RequestMapping(value = "user/validateemail.htm", method = RequestMethod.GET)
	public String validateEmail(HttpServletRequest request, UserDAO userDAO, ModelMap map){
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		int key1 = Integer.parseInt(request.getParameter("key1"));
		int key2 = Integer.parseInt(request.getParameter("key2"));
		
		if((Integer)(session.getAttribute("key1"))==key1 && (Integer)(session.getAttribute("key2"))==key2 ){
			try{
				boolean updateStatus = userDAO.updateUser(email);
				if(updateStatus){
					return "user-login";
				}
				else{
					return "error";
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			map.addAttribute("errorMessage","link expired, please generate new link");
			map.addAttribute("resendLink", true);
			return "error";
		}
		return "user-login";
	}
}