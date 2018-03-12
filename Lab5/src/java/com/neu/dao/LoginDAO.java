/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.Login;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Wenqing
 */
public class LoginDAO {
    
    public boolean checkLogin(Login login){
        java.sql.Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/usersdb", "student", "p@ssw0rd");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        System.out.println(login.getUsername());
        
        String query = "SELECT * FROM userstable where userName ='" + login.getUsername()+"' and userPassword='"+login.getPassword()+"'" ;
          System.out.println(query);
        try {
            ResultSet rs = stmt.executeQuery(query); /// check this line
          
            if(rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }
       return false;
    }    
}