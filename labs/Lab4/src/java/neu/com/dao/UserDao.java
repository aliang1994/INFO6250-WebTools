/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import neu.com.pojo.User;

/**
 *
 * @author Wenqing
 */
public class UserDao {
    public ArrayList<User> getUsers(){
        Connection connection = null;
        Statement stmt = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/usersdb","student","p@ssw0rd");
            stmt = connection.createStatement();
        }
        catch(SQLException ex){
            
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String query = "Select * from users";
        ArrayList<User> userList = new ArrayList<User>();
        
        try{
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User user = new User();
                user.setUserid(rs.getInt("userId"));
                user.setFirstname(rs.getString("fname"));
                user.setLastname(rs.getString("lname"));
                user.setEmail(rs.getString("email"));
                
                userList.add(user);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);            
        }
        finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            }
            catch(SQLException ex){
                System.out.println(ex);
            } 
        }        
        return userList;
    }
}