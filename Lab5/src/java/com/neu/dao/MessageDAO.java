/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.Message;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MessageDAO {

    public ArrayList<Message> getMessages(String username) {
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

        String query = "SELECT * FROM messages where userName='" + username + "'";
        ArrayList<Message> msgList = new ArrayList<Message>();
        try {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Message msg = new Message();
                msg.setMessageId(rs.getInt("messageId"));
                msg.setUsername(rs.getString("userName"));
                msg.setFromUser(rs.getString("fromUser"));
                msg.setMessage(rs.getString("message"));
                msg.setMessageDate(rs.getString("messageDate"));
                msgList.add(msg);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
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

        return msgList;
    }

    public ArrayList<Message> getMessagesByQuery(String query,String username) {
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

        String sqlQuery = "SELECT * FROM messages WHERE userName='" + username + "' and (message LIKE '%" + query + "%' or fromUser like '%" + query + "%') ";
        System.out.println(sqlQuery);
        ArrayList<Message> msgList = new ArrayList<Message>();
        try {
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while (rs.next()) {
                Message msg = new Message();
                msg.setMessageId(rs.getInt("messageId"));
                msg.setUsername(rs.getString("userName"));
                msg.setFromUser(rs.getString("fromUser"));
                msg.setMessage(rs.getString("message"));
                msg.setMessageDate(rs.getString("messageDate"));
                msgList.add(msg);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
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

        return msgList;
    }

    public boolean addMessage(Message msg) {
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

        String sqlQuery = "INSERT INTO messages (fromUser, userName, message, messageDate) "
                + "VALUES ('" + msg.getFromUser() + "', '" + msg.getUsername() + "','" + msg.getMessage() + "','" + msg.getMessageDate() + "')";
        try {
            stmt.executeUpdate(sqlQuery);
            System.out.println(sqlQuery);

        } catch (SQLException ex) {
            System.out.println(ex);
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
    
    public boolean deleteMessage(int msgId) {
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

        String sqlQuery = "DELETE FROM messages where messageId = "+msgId+";";
        try {
            System.err.println(sqlQuery);
            int result = stmt.executeUpdate(sqlQuery);
            if(result == 0){
                return false;
            }
           else{
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
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
