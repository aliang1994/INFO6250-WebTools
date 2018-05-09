/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.controller;

import book.pojo.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */
@Controller
@RequestMapping("/book.htm")
public class BookController {
    
    public BookController() {
    }
    
    
    private Book AddBook(Book b){
        Configuration conf = new Configuration();
        SessionFactory sf = conf.configure("hibernate.cfg.xml").buildSessionFactory();
        Session ses = sf.openSession();
        Transaction tx = ses.beginTransaction();
        ses.save(b);
        tx.commit();
        return b;
    }
    
    
    
    @RequestMapping(value = "/book.htm")
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession(true);
        int noBook = (int) session.getAttribute("noBooks");    
        
        try{          
            for(int i=1;i<=noBook;i++)        {
                Book book = new Book();
                String isbn = request.getParameter("isbn"+i);
                String title = request.getParameter("bookTitle"+i);
                String author = request.getParameter("authors"+i);
                Float price = Float.parseFloat(request.getParameter("price"+i));
                
                book.setIsbn(isbn);
                book.setTitle(title);
                book.setAuthor(author);
                book.setPrice(price);     
                
                AddBook(book);
                return new ModelAndView("goback");
            }
        }
        catch(Exception exp){
            System.out.println("Exception when adding books: " + exp.getMessage());
            return new ModelAndView("addBook");
        }    
        return new ModelAndView("addBook");
    }    
}