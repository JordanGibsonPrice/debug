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

import com.revature.beans.Application;  
  
  
public class RegisterApplication extends HttpServlet {  
 public void doGet(HttpServletRequest request, HttpServletResponse  
   response)throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
      
    long before=System.currentTimeMillis();  
          
    ServletContext context=getServletContext();  
    List list=(List)context.getAttribute("data");  
          
    Iterator itr=list.iterator();  
    while(itr.hasNext()){  
     Application a=(Application)itr.next();  
     out.print("<br>"+a.getAppID()+" "+a.getEmpFirst()+" "+a.getEmpLast()+" "+a.getExpense()+" "+a.getGrade()+" "+a.getEventType());  
    }  
    long after=System.currentTimeMillis();  
    out.print("<br>total time :"+(after-before));  
          
    out.close();  
    }  
  
}  
//maybe keep track of how many times a user has visited, not necessary 
//create a session or a cookie
