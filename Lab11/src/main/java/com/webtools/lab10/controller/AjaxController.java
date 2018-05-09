package com.webtools.lab10.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	ArrayList<String> courseList;
	public AjaxController(){
		courseList = new ArrayList<String>();
		courseList.add("AED");
		courseList.add("web tools");
		courseList.add("web design");
		courseList.add("data science");
	}
	
	@RequestMapping (value = "/ajaxservice.htm", method = RequestMethod.POST)
	@ResponseBody
	public String ajaxService(HttpServletRequest request){
		String queryString = request.getParameter("course");
		String result = "";
		for(int i=0; i< courseList.size(); i++){
			if(courseList.get(i).toLowerCase().contains(queryString.toLowerCase())){
				result += courseList.get(i) + ", ";
			}			
		}
		return result;
	} 
}
