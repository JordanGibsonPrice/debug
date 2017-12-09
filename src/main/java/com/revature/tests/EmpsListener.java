package com.revature.tests;

import javax.servlet.ServletContext;  
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;

import com.revature.beans.Employee;

import java.sql.*;  
import java.util.ArrayList;  
  
public class EmpsListener implements ServletContextListener{  
  
 public void contextInitialized(ServletContextEvent i) {  
          
  ArrayList list = new ArrayList();  
   try{  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
    Connection con=DriverManager.getConnection(  
    		"jdbc:oracle:thin:@sandbox171106.c7gydzn7nvzj.us-east-1.rds.amazonaws.com:1521:orcl","jordan", "jordan1234");  
              
    PreparedStatement ps = con.prepareStatement("select * from Employees");  
    ResultSet rs = ps.executeQuery();  
    while(rs.next()){  
     Employee e =new Employee();  
     e.setUsername(rs.getString(1));  
     e.setPassword(rs.getString(2));  
     e.setEmail(rs.getString(3));
     e.setFname(rs.getString(4));
     e.setLname(rs.getString(5));
     list.add(e);  
    }  
    con.close();  
              
   }catch(Exception ex){System.out.print(ex);}  
  
   //storing the ArrayList object in ServletContext       
   ServletContext context=i.getServletContext();  
   context.setAttribute("data",list);  
          
 }  
 public void contextDestroyed(ServletContextEvent arg0) {  
    System.out.println("project undeployed...");  
 }  
  
}  


 