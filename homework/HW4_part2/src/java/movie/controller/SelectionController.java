/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */
public class SelectionController extends AbstractController {
    
    public SelectionController() {
    }
    
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