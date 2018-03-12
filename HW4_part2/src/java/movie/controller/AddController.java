/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import movie.pojo.Movie;
import movie.validator.MovieValidator;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Wenqing
 */
public class AddController extends SimpleFormController {
    
    public AddController() {        
        setCommandClass(Movie.class);
        setCommandName("addnewmovie");        
        setValidator(new MovieValidator());
        setFormView("addmovie");
        setSuccessView("addsuccessful");
    }
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        //on submit: when the form in FormView is submitted
        ModelAndView mav = new ModelAndView(this.getSuccessView());
        Movie movie = (Movie) command;   //command class movie
       
        DataSource ds = (DataSource) this.getApplicationContext().getBean("dataSource");
        Connection con = null;
        PreparedStatement pst = null;
        try{
            con = ds.getConnection();//
            String updateString = "Insert into movies (title,actor,actress,genre,releaseyear) values(?,?,?,?,?)";
               
            String title = movie.getTitle();
            String actor = movie.getLeadactor();
            String actress = movie.getLeadactress();
            String genre = movie.getGenre();
            int year = movie.getYear();
            
            pst = con.prepareStatement(updateString);
            pst.setString(1,title);
            pst.setString(2,actor );
            pst.setString(3,actress);
            pst.setString(4,genre );
            pst.setInt(5, year);
        }
        catch(SQLException exp){
            System.out.println("SQLException" + exp.getMessage());
        }
        catch(NumberFormatException exp){
            System.out.println("NumberFormatException" + exp.getMessage());
        }
        finally{
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } 
            catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
            catch(NumberFormatException exp){
                System.out.println("NumberFormatException" + exp.getMessage());
            }
        }
       return mav;
    }
}