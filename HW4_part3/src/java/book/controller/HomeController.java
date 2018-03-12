/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */
public class HomeController extends AbstractController {
    
    public HomeController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {  
        
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