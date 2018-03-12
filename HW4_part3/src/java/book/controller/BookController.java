/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */
public class BookController extends AbstractController {
    
    public BookController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession(true);
        int noBook = (int) session.getAttribute("noBooks");       
        
        DataSource ds = (DataSource) this.getApplicationContext().getBean("dataSource");
        Connection con = null;
        PreparedStatement pst = null;
        try{
            con = ds.getConnection();

            String updateString = "Insert into books (isbn,title,authors,price) values(?,?,?,?)";
            
            
            for(int i=1;i<=noBook;i++)        {
                String isbn = request.getParameter("isbn"+i);
                String title = request.getParameter("bookTitle"+i);
                String author = request.getParameter("authors"+i);
                Float price = Float.parseFloat(request.getParameter("price"+i));
                
                pst = con.prepareStatement(updateString);
                pst.setString(1,isbn);
                pst.setString(2,title );
                pst.setString(3,author);
                pst.setFloat(4,price );
            }
        }
        catch(SQLException exp){
            System.out.println("SQLException" + exp.getMessage());
        }
        finally{
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        return new ModelAndView("goback");
    }    
}