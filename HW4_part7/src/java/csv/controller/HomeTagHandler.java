/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv.controller;

import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.DataSource;

/**
 *
 * @author Wenqing
 */
public class HomeTagHandler extends SimpleTagSupport {

    private String filename;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();  
        int j=0;
        try {
//            StringWriter sw = new StringWriter();
//            getJspBody().invoke(sw);
//            String filename = sw.toString();
            
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Connection con = DriverManager.getConnection("jdbc:relique:csv:C:\\tomcat8.5" );
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM " + filename;
            ResultSet rs = stmt.executeQuery(query);
         
            HashMap<String, ArrayList> hashmap = new HashMap<String, ArrayList>();
            out.println("<table border=\"1\">");
            while(rs.next()){
                ArrayList<String> arrayList = new ArrayList<String>(25);
                out.println("<tr>");
                for(int i = 1; i<26; i++){
                    arrayList.add(rs.getString(i));//get content in each column by index
                    out.println("<td>"+rs.getString(i)+"</td>");
                }
                out.println("</tr>");
                hashmap.put("Row"+j, arrayList);
                j++;
            }
            out.println("</table>"); 
            getJspContext().setAttribute("CSVData", hashmap, PageContext.SESSION_SCOPE);
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            
        } 
        catch (java.io.IOException ex) {
            System.out.println("IOException: " +  ex.getMessage());
        } 
        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException: " +  ex.getMessage());
        } 
        catch (SQLException ex) {
            System.out.println("SQLException: " +  ex.getMessage());
        }
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}