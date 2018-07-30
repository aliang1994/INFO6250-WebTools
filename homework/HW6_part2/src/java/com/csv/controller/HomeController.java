/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csv.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */
@Controller
public class HomeController  {
    //100 records per page
    private static int startcount=0;
    private static String filename;
    private static boolean isInserted = false;
    
    @Autowired
    private ApplicationContext context;
    
    @RequestMapping(value = "/name.htm")
    protected ModelAndView extractFromCSV(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //String uri = request.getRequestURI();
        ModelAndView mav = null;
        HttpSession session = request.getSession(true);
        int j = 0;
        
            Connection con = null;
            Statement statement = null;
            try{
                String pagenum = request.getParameter("pagenum");
                if(pagenum==null){
                    String input = request.getParameter("filename");
                    this.filename = input;
                }
                else{            
                    startcount = (Integer.parseInt(request.getParameter("pagenum"))-1)*100;
                }        
                
                DataSource ds = (DataSource)context.getBean("csvdata");
                con = ds.getConnection();
                statement = con.createStatement();
                
                
                String query = "SELECT * FROM " + filename + " LIMIT 100 OFFSET " + startcount + " ";
                ResultSet resultSet = statement.executeQuery(query);


                HashMap<String, ArrayList> hashmap = new HashMap<String, ArrayList>();
                while(resultSet.next()){
                    ArrayList<String> arrayList = new ArrayList<String>(25);
                    for(int i = 1; i<26; i++){
                        arrayList.add(resultSet.getString(i));//get content in each column by index
                    }
                    hashmap.put("Row"+j, arrayList);
                    j++;
                }
                session.setAttribute("CSVData", hashmap);
            }
            catch(Exception exp){
                System.out.println("Exception" + exp.getMessage());
            }
            finally{
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } 
                catch (SQLException ex) {
                    System.out.println("SQLException" + ex.getMessage());
                }
             }
            mav = new ModelAndView("index");    
            return mav;
        }
    
    @RequestMapping(value = "/addrow.htm", method = RequestMethod.POST)
    private ModelAndView addToDatabase (HttpServletRequest request, HttpServletResponse response) throws Exception {    
        if(filename==null){
            return new ModelAndView("index");
        }
        
        HttpSession session = request.getSession(true);
        ModelAndView mav = null;
        
            HashMap hashmap = (HashMap) session.getAttribute("CSVData");
            DataSource ds = (DataSource) context.getBean("database");
            Connection con = null;
            PreparedStatement pst  = null;
            try{
                con = ds.getConnection();     
                con.setAutoCommit(false);
                String updatequery = "INSERT INTO SALESORDERCSV "
                    + "(SalesOrderID,RevisionNumber,OrderDate,"
                    + "DueDate,ShipDate,Status,OnlineOrderFlag,"
                    + "SalesOrderNumber,PurchaseOrderNumber,AccountNumber,"
                    + "CustomerID,SalesPersonID,TerritoryID,BillToAddressID,"
                    + "ShipToAddressID,ShipMethodID,CreditCardID,CreditCardApprovalCode,"
                    + "CurrencyRateID,SubTotal,TaxAmt,Freight,TotalDue,Comment,ModifiedDate)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                pst = con.prepareStatement(updatequery);
                // iterate the hashmap
                Iterator iter = hashmap.entrySet().iterator(); 
                while (iter.hasNext()) { 
                    Map.Entry entry = (Map.Entry) iter.next(); 
                    ArrayList<String> row = (ArrayList<String>)entry.getValue();
                    for(int k=0; k<row.size(); k++){
                        String colvalue = row.get(k);
                        if(colvalue.equalsIgnoreCase("NULL")){
                            pst.setString(k+1, null);
                        }
                        else {
                            pst.setString(k+1, colvalue);
                        }                    
                    }      
                    pst.addBatch();
                }             
                int[] res = pst.executeBatch();
                int count = 0;
                for(int i : res){
                    count = count + i;
                }
                con.commit();

                session.setAttribute("DataCount", count);

                mav = new ModelAndView("index");
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
            } 
            catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }        
        isInserted = true;
        return mav;        
    }   
    
    @RequestMapping(value = "/display.xls", method = RequestMethod.GET)
    protected ModelAndView displayExcel (HttpServletRequest request, HttpServletResponse response) throws Exception{
        if(filename==null || isInserted == false){
            return new ModelAndView("index");
        }
        HttpSession session = request.getSession(true);
        DataSource ds = (DataSource) context.getBean("database");
        Connection con = null;
        Statement statement = null;
        int j=0;
        
        
        
        int numstart = 0;
            try{
                con = ds.getConnection();     
                con.setAutoCommit(false);
                
                statement = con.createStatement();                
                
                String query = "SELECT * FROM salesordercsv";
                ResultSet resultSet = statement.executeQuery(query);


                HashMap<String, ArrayList> hashmap = new HashMap<String, ArrayList>();
                while(resultSet.next()){
                    ArrayList<String> arrayList = new ArrayList<String>(25);
                    for(int i = 1; i<26; i++){
                        arrayList.add(resultSet.getString(i));//get content in each column by index
                    }
                    hashmap.put("Row"+j, arrayList);
                    j++;
                }
                session.setAttribute("jspdata", hashmap);
               
                con.commit();
                return new ModelAndView("excelview", "jspdata", hashmap);
            }
            catch(Exception exp){
                System.out.println("Exception" + exp.getMessage());            
        }
        finally{
            try {
                if (statement != null) {
                    statement.close();
                }
                if (con != null) {
                    con.close();
                }
            } 
            catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }        
        return new ModelAndView("index");
    }
}