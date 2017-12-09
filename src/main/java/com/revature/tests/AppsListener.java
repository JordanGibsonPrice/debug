package com.revature.tests;

import javax.servlet.ServletContext;  
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;

import com.revature.beans.Application;
import com.revature.beans.Employee;

import java.sql.*;  
import java.util.ArrayList;  
  
public class AppsListener implements ServletContextListener{  
  
 public void contextInitialized(ServletContextEvent i) {  
          
  ArrayList list = new ArrayList();  
   try{  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
    Connection con=DriverManager.getConnection(  
    		"jdbc:oracle:thin:@sandbox171106.c7gydzn7nvzj.us-east-1.rds.amazonaws.com:1521:orcl","jordan", "jordan1234");  
              
    PreparedStatement ps = con.prepareStatement("select * from Applications");  
    ResultSet rs = ps.executeQuery();  
    while(rs.next()){  
     Application a = new Application(); 
     a.setEmpID(rs.getInt(1));  //Needs a check to make sure that user exists, just like login
     a.setAccNum(rs.getInt(2)); 
     a.setDeptNum(rs.getInt(3));
     a.setEmail(rs.getString(4));
     a.setEmpFirst(rs.getString(5));
     a.setEmpLast(rs.getString(6));
     a.setBlobbert(rs.getBlob(7));
 		
     list.add(a);  
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