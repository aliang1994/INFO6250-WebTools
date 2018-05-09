/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.pojo;

/**
 *
 * @author Wenqing
 */
public class Movie {
    private int id;
    private String title;
    private String leadactor;
    private String leadactress;
    private String genre;
    private Integer year;
    
    public Movie(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLeadactor() {
        return leadactor;
    }

    public void setLeadactor(String leadactor) {
        this.leadactor = leadactor;
    }

    public String getLeadactress() {
        return leadactress;
    }

    public void setLeadactress(String leadactress) {
        this.leadactress = leadactress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    
    public String toString(){
        return title;
    }
}