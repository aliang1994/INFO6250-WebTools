/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.controller;

import javax.servlet.http.HttpServletRequest;
import movie.dao.MovieDAO;
import movie.pojo.Movie;
import movie.validator.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Wenqing
 */
@Controller
@RequestMapping("/add.htm")
public class AddController {
    @Autowired
    @Qualifier("mdao")
    MovieDAO moviedao;
    
    
    @Autowired
    @Qualifier("mvalidator")
    MovieValidator movievalidator;
    
//    public AddController() {        
//        setCommandClass(Movie.class);
//        setCommandName("addnewmovie");        
//        setValidator(new MovieValidator());
//        setFormView("addmovie");
//        setSuccessView("addsuccessful");
//    }
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
	binder.setValidator(movievalidator);
    }
    
    @RequestMapping(value = "/add.htm", method = RequestMethod.POST)
    protected ModelAndView addSuccess (@ModelAttribute("movie") Movie movie, BindingResult result) throws Exception {
        movievalidator.validate(movie, result);
        if(result.hasErrors()){
            return new ModelAndView("addmovie");
        }
        try{
            moviedao.addMovie(movie);        
            ModelAndView mav = new ModelAndView("addsuccessful","movie",movie);        
            return mav;
        }
        catch(Exception e){
            System.out.println("Error in adding new movie: " + e.getMessage());
            ModelAndView mav = new ModelAndView("error");
            return mav;
        }        
    }
    
    
    @RequestMapping(value = "/add.htm", method = RequestMethod.GET)
    protected ModelAndView addForm (HttpServletRequest request) throws Exception {              
        ModelAndView mav = new ModelAndView();        
        mav.addObject("movie", new Movie());
        mav.setViewName("addmovie");
        return mav;
    }
}