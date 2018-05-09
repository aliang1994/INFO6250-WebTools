/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Wenqing
 */
@Controller
@RequestMapping("/home.htm")
public class HomeController  {
    
    public HomeController() {
    }
    
    private void askForPassword(HttpServletResponse response) {
        response.setStatus(response.SC_UNAUTHORIZED); // I.e., 401
        response.setHeader("WWW-Authenticate",
        "BASIC realm=\"Insider-Trading\"");
    }
    
    @RequestMapping(value = "/home.htm")
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {  
        
        
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            askForPassword(response);
        } 
        else {
            // Authorization headers looks like "Basic blahblah",
            // where blahblah is the base64 encoded username and
            // password. We want the part after "Basic ".
            String userInfo = authorization.substring(6).trim();
            BASE64Decoder decoder = new BASE64Decoder();
            String nameAndPassword =
            new String(decoder.decodeBuffer(userInfo));
            // Decoded part looks like "username:password".
            int index = nameAndPassword.indexOf(":");
            String user = nameAndPassword.substring(0, index);
            String password = nameAndPassword.substring(index+1);        
        }
        
        if(request.getParameter("action")!=null){
            if(request.getParameter("action").equals("back")){                
                return new ModelAndView("index");
            }
        }
        
        HttpSession session = request.getSession(true);
   
        int noBooks = Integer.parseInt(request.getParameter("noBooks"));
        session.setAttribute("noBooks",noBooks);
        
        ModelAndView mv = new ModelAndView("addBook");
        return mv;
    }    
}