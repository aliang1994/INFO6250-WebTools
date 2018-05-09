/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import movie.dao.MovieDAO;
import movie.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wenqing
 */
@Controller
@RequestMapping("/browse.htm")
public class BrowseController  {
    @Autowired
    @Qualifier("mdao")
    MovieDAO moviedao;
    
    public BrowseController() {
    }
    
    @RequestMapping(value = "/browse.htm")
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mav = new ModelAndView("searchdb");        
        String querykw = request.getParameter("querykw");
        
        HttpSession ses = request.getSession(true);
        ses.setAttribute("keyword", querykw);
        
        String criteria = request.getParameter("criteria");
        if(criteria==null){
            return mav;
        }
        else{
            List<Movie> searchresult = moviedao.searchMovie(criteria,querykw);
            ses.setAttribute("searchresult", searchresult);            
            return new ModelAndView("searchresults","result", searchresult);
        }  
    }
}