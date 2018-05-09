/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Wenqing
 */
@Entity
@Table(name = "books")
public class Book implements Serializable {
    public Book()    {
        
    }
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "bookid", unique=true, nullable = false)
    int id;
    
    @Column(name = "bookisbn")
    String isbn;
    
    @Column(name = "booktitle")
    String title;
    
    @Column(name = "bookauthor")
    String author;
    
    @Column(name = "bookprice")
    double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
