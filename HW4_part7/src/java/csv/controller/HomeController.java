/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Wenqing
 */
public class HomeController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uri = request.getRequestURI();
        ModelAndView mav = null;
        HttpSession session = request.getSession(true);
        
        int j = 0;
        
        if(uri.contains("name.htm")){
            String filename = request.getParameter("filename");
            session.setAttribute("filename", filename);
            mav = new ModelAndView("index");                    
        } 
        if(uri.contains("addrow.htm")){            
            HashMap hashmap = (HashMap) session.getAttribute("CSVData");
            DataSource ds = (DataSource) this.getApplicationContext().getBean("database");
            Connection con = null;
            PreparedStatement pst  = null;
            try{
                con = ds.getConnection();            
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
                //int count = pst.executeUpdate();
                int[] res = pst.executeBatch();
                int count = 0;
                for(int i : res){
                    count = count + i;
                }
                session.setAttribute("DataCount", count);
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
                mav = new ModelAndView("index");
            }
        return mav;        
    }    
}