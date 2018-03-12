/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Wenqing
 */
public class User {
    private String username;
    private String password;
    private CommonsMultipartFile photo;
    private String photofile;

    public String getPhotofile() {
        return photofile;
    }

    public void setPhotofile(String photofile) {
        this.photofile = photofile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CommonsMultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(CommonsMultipartFile photo) {
        this.photo = photo;
    }
    
    
    
}
