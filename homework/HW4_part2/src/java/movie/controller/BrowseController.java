/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class BrowseController extends AbstractController {
    
    public BrowseController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mav = new ModelAndView("searchdb");
        
        String querykw = request.getParameter("querykw");
        HttpSession ses = request.getSession(true);
        ses.setAttribute("keyword", querykw);
        String criteria = request.getParameter("criteria");
        if(criteria==null){
            return mav;
        }
        
        DataSource ds = (DataSource) this.getApplicationContext().getBean("dataSource");
        Connection con = null;
        Statement st = null;
        HashMap<Integer, ArrayList> map = new HashMap<>();
        ArrayList row = new ArrayList<>();
        int count=0;
        try{
            con = ds.getConnection();
            st = con.createStatement();
            if(criteria.equals("bytitle")){
                String sql = "SELECT * FROM MOVIES WHERE TITLE = "+querykw;
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    count++;
                    for(int k=1; k<6; k++){
                        Object obj = rs.getObject(k);
                        row.add(obj);
                    }
                    map.put(count, row);
                }
                ses.setAttribute("searchresult", map);
                return new ModelAndView("searchresults");
             }
            if(criteria.equals("byactor")){
                String sql = "SELECT * FROM MOVIES WHERE ACTOR = "+querykw;
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    count++;
                    for(int k=1; k<6; k++){
                        Object obj = rs.getObject(k);
                        row.add(obj);
                    }
                    map.put(count, row);
                }
                ses.setAttribute("searchresult", map);
                return new ModelAndView("searchresults");
             }
            if(criteria.equals("byactress")){
                String sql = "SELECT * FROM MOVIES WHERE ACTRESS = "+querykw;
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    count++;
                    for(int k=1; k<6; k++){
                        Object obj = rs.getObject(k);
                        row.add(obj);
                    }
                    map.put(count, row);
                }
                ses.setAttribute("searchresult", map);
                return new ModelAndView("searchresults");
             }
            if(criteria.equals("bygenre")){
                String sql = "SELECT * FROM MOVIES WHERE GENRE = "+querykw;
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    count++;
                    for(int k=1; k<6; k++){
                        Object obj = rs.getObject(k);
                        row.add(obj);
                    }
                    map.put(count, row);
                }
                ses.setAttribute("searchresult", map);
                return new ModelAndView("searchresults");
             }
            if(criteria.equals("byyear")){
                String sql = "SELECT * FROM MOVIES WHERE RELEASEYEAR = "+querykw;
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    count++;
                    for(int k=1; k<6; k++){
                        Object obj = rs.getObject(k);
                        row.add(obj);
                    }
                    map.put(count, row);
                }
                ses.setAttribute("searchresult", map);
                return new ModelAndView("searchresults");
             }
        }
        catch(SQLException exp){
            System.out.println("SQLException" + exp.getMessage());
        }
        finally{
            try {
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        return mav;
    }
}