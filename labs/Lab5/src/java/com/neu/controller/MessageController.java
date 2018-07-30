/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.MessageDAO;
import com.neu.pojo.Message;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


/**
 *
 * @author Wenqing
 */
public class MessageController extends AbstractController {
    
    public MessageController(){
        
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //Checked if the user alreay logged in 
        //If not send to login page else continue 
        String username = (String) request.getSession().getAttribute("username");
        if (username == null) {
            return new ModelAndView("error");
        }

        MessageDAO mdao = (MessageDAO) this.getApplicationContext().getBean("messagedao");
        
        if (request.getRequestURI().endsWith("send.htm")) {
            return new ModelAndView("messageview", "msgtype", "send");
        } 
        else if (request.getRequestURI().endsWith("display.htm")) {

            ArrayList<Message> msgList = mdao.getMessages(username);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("msgList", msgList);
            map.put("msgtype", "display");
            return new ModelAndView("messageview", "map", map);
        } 
        else if (request.getRequestURI().endsWith("delete.htm")) {
            ModelAndView mav=null;
            String uri = request.getRequestURI();
            System.out.println("URI - " + uri);

            String arr[] = uri.split("/");
            try {
                int messageIdToDelete = Integer.parseInt(arr[arr.length - 2]);
                System.out.println("Message ID to delete :"+messageIdToDelete);
                boolean isMessageDeleted = mdao.deleteMessage(messageIdToDelete);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("msgtype", "delete");
                if(isMessageDeleted){
                    map.put("status", "deleted");
                    mav = new ModelAndView("messageview", "map", map);
                }
                else{
                    map.put("status", "notdeleted");
                    new ModelAndView("messageview", "map", map);
                }
            } 
            catch (Exception e) {
                System.err.println("Delete operation failed!" + e);
            }
            //Implement the delete method
            return mav;
            } 
        else if (request.getRequestURI().endsWith("search.htm")) {

            String query = request.getParameter("searchQuery");
            ArrayList<Message> msgList = mdao.getMessagesByQuery(query, username);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("msgList", msgList);
            map.put("msgtype", "search");
            map.put("querySearched", query);
            return new ModelAndView("messageview", "map", map);
        } 
        else if (request.getRequestURI().endsWith("sendemail.htm")) {
            Message msg = new Message();
            msg.setFromUser(username);
            msg.setMessage(request.getParameter("message"));
            msg.setUsername(request.getParameter("to"));
            Date d = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            String date = format.format(d);
            msg.setMessageDate(date);
            mdao.addMessage(msg);
            return new ModelAndView("emailsuccess","message","Message Sent Successfully!");
        } 
        else if (request.getRequestURI().endsWith("dashboard.htm")) {
            return new ModelAndView("loginsuccess");
        } 
        else {
            return null;
        }
    }
}
        
        
    

  


