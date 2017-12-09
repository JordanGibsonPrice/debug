package com.revature.servlets;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.util.Iterator;  
import java.util.List;  
  
import javax.servlet.ServletContext;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Employee;  
  
  
public class RegisterEmployee extends HttpServlet {  
 public void doGet(HttpServletRequest request, HttpServletResponse  
   response)throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
      
    long before=System.currentTimeMillis();  
          
    ServletContext context=getServletContext();  
    List list=(List)context.getAttribute("data");  
          
    Iterator itr=list.iterator();  
    while(itr.hasNext()){  
     Employee e = (Employee)itr.next();  
     out.print("<br>"+e.getEmpID()+" "+e.getUsername()+" "+e.getPassword());  
    }  
          
    long after=System.currentTimeMillis();  
    out.print("<br>total time :"+(after-before));  
          
    out.close();  
    }  
  
	
}