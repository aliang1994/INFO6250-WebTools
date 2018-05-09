/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/**
 *
 * @author Wenqing
 */
public class InputFilter implements Filter {
    
    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);
    }

}

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//    @Override
//    public void destroy() {
//    }  
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        RequestWrapper rw = new RequestWrapper((HttpServletRequest) request);
//        chain.doFilter(rw, response);
//    }
//
//    
//    private class RequestWrapper extends HttpServletRequestWrapper  {
//    
//        public RequestWrapper(HttpServletRequest request) {
//            super(request);
//        }        	        
//	public String sanitize(String string){
//	            string = string.replace("<", "");
//	            string = string.replace(">","");
//	            string = string.replace(";","");
//	            string = string.replace("#","");
//	            string = string.replace("?","");
//	            string = string.replace("*","");
//	            string = string.replace("&","");
//	            string = string.replace("@","");
//	            string = string.replace("%","");
//	            string = string.replace("^","");
//	            string = string.replace("$","");
//	            string = string.replace("(","");
//	            string = string.replace(")","");
//	            string = string.replace("{","");
//	            string = string.replace("}","");
//	            string = string.replace("\"","");
//	            string = string.replace("=","");
//	            string = string.replace("!","");
//	            string = string.replace("'","");
//	       
//	            return string;
//	        }
//	        
//	protected Hashtable localParams = null;
//	        
//	public void setParameter(String name, String[] values) {	            
//	    if (localParams == null) {
//	        localParams = new Hashtable();
//	                // Copy the parameters from the underlying request.
//	        Map wrappedParams = getRequest().getParameterMap();
//	        Set keySet = wrappedParams.keySet();
//	        for (Iterator it = keySet.iterator(); it.hasNext();) {
//	            Object key = it.next();
//	            Object value = wrappedParams.get(key);
//	            localParams.put(key, value);
//	        }
//	    }
//	    localParams.put(name, values);
//	}
//	        
//	@Override
//	public String getParameter(String name) {	
//            System.out.println("parameters: " + super.getParameter(name));
//                    
//	    if (localParams == null) {
//	        return sanitize(super.getParameter(name));
//	    }
//	    Object val = localParams.get(name);
//	    if (val instanceof String) {
//	        return (String) val;
//	    }
//	    if (val instanceof String[]) {
//	        String[] values = (String[]) val;
//	        return values[0];
//	    }
//	    return (val == null ? null : val.toString());
//	}
//	        
//	        @Override
//	        public String[] getParameterValues(String name) {
//	            if (localParams == null) {
//	                return getRequest().getParameterValues(name);
//	            }
//	            return (String[]) localParams.get(name);
//	        }
//	        
//	        @Override
//	        public Enumeration getParameterNames() {
//	            if (localParams == null) {
//	                return getRequest().getParameterNames();
//	            }
//	            return localParams.keys();
//	        }        
//	        
//	        @Override
//	        public Map getParameterMap() {
//	            if (localParams == null) {
//	                return getRequest().getParameterMap();
//	            }
//	            return localParams;
//	        }
//
//    }
