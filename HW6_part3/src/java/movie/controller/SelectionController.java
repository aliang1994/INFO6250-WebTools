/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */

@Controller
@RequestMapping("/select.htm")
public class SelectionController{
    
    public SelectionController() {
    }
    
    @RequestMapping(value = "/select.htm")
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        String attr = request.getParameter("selectmenu");
        HttpSession ses = request.getSession(true);
        ses.setAttribute("selection",attr);
        
        if(attr.equals("browse")){
            return new ModelAndView("redirect:browse.htm");
        }
        if(attr.equals("add")){
            return new ModelAndView("redirect:add.htm");
        }
        return new ModelAndView("welcome");
    }
}